/*
 *     Copyright (C) 2020 - pedro.oliveira20@gmail.com
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.com.ppm.commons.object;

import br.com.ppm.commons.annotation.ToStringExclude;
import br.com.ppm.commons.annotation.ToStringStyle;
import br.com.ppm.commons.annotation.ToStringStyle.Style;
import br.com.ppm.commons.string.KeyValueAppender;
import br.com.ppm.commons.string.ToStringBuilder;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static br.com.ppm.commons.annotation.ToStringStyle.Style.NO_STYLE;
import static br.com.ppm.commons.string.ToStringConstants.*;

/**
 * Class ToStringBuilder is a Utility class to implement java toString pattern.
 *
 * @author Pedro T. Oliveira (pedrotoliveira)
 * @since 05/15/2013
 */
public final class ObjectsToStringBuilder implements ToStringBuilder {

    private final Object object;

    public ObjectsToStringBuilder(final Object object) {
        this.object = object;
    }

    @Override
    public String build(final boolean ignoreSuperType, final Style style) {
        if (object == null) {
            return KeyValueAppender.start("Object")
                    .appendSeparator(EQUAL)
                    .appendNullValue()
                    .getBuilder()
                    .toString();
        }

        KeyValueAppender appender = KeyValueAppender.start(object.getClass().getSimpleName());
        appender.appendSeparator(OPEN_BRACKET);
        Field[] fields = !ignoreSuperType && hasSuperType(object)
                ? extractSuperClassFields(object)
                : object.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (isToPrintField(field)) {
                Style selectedStyle = selectStyle(style, field);
                appender.appendKeyValue(object, field, selectedStyle);
            }
        }
        return appender.deleteLastComma().appendTerminator(CLOSE_BRACKET);
    }

    private Style selectStyle(Style current, Field field) {
        return (current == NO_STYLE) ? getFieldStyle(field) : current;
    }

    private Style getFieldStyle(Field field) {
        return field.isAnnotationPresent(ToStringStyle.class)
                ? field.getAnnotation(ToStringStyle.class).value()
                : Style.REFLECTION;
    }

    private Field[] extractSuperClassFields(Object o) {
        Field[] classFields = o.getClass().getDeclaredFields();
        Stream<Field> superFields = Arrays.stream(o.getClass().getSuperclass().getDeclaredFields());
        List<Field> fields = new ArrayList<>();
        superFields
                .filter(field -> isNotOn(classFields, field))
                .forEach(fields::add);
        if (fields.isEmpty()) {
            return classFields;
        } else {
            Collections.addAll(fields, classFields);
            return fields.toArray(new Field[]{});
        }
    }

    private boolean isNotOn(Field[] classFields, Field field) {
        for (Field classField : classFields) {
            if (field.getName().equals(classField.getName()) && field.getType().equals(classField.getType())) {
                return false;
            }
        }
        return true;
    }

    private boolean hasSuperType(Object o) {
        return !(o.getClass().getSuperclass().equals(Object.class));
    }

    private boolean isToPrintField(Field field) {
        return !(field.isAnnotationPresent(ToStringExclude.class)
                || "serialVersionUID".equals(field.getName())
                || "this$0".equals(field.getName())
                || Modifier.isStatic(field.getModifiers()));
    }
}
