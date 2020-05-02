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

import br.com.ppm.commons.string.KeyValueAppender;
import br.com.ppm.commons.string.ToStringBuilder;
import br.com.ppm.commons.annotation.ToStringExclude;
import br.com.ppm.commons.annotation.ToStringStyle;
import br.com.ppm.commons.annotation.ToStringStyle.Style;
import br.com.ppm.commons.array.ArraysToStringBuilder;
import br.com.ppm.commons.collection.CollectionToStringBuilder;
import br.com.ppm.commons.map.MapToStringBuilder;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

import static br.com.ppm.commons.string.ToStringConstants.CLOSE_SQUARE_BRACKET;
import static br.com.ppm.commons.string.ToStringConstants.OPEN_SQUARE_BRACKET;
import static br.com.ppm.commons.annotation.ToStringStyle.Style.NO_STYLE;
import static br.com.ppm.commons.type.Types.*;

/**
 * Class ToStringBuilder is a Utility class to implement java toString pattern.
 *
 * This implementation should be more realible, faster and secure them other ToStringBuilders on the market.
 *
 * @author Pedro T. Oliveira (pedrotoliveira)
 * @since 05/15/2013
 *
 */
public final class ObjectsToStringBuilder implements ToStringBuilder {

    private static final String TO_MANY_TO_STRING_CALLS_VIOLATION = "[Error on ToStringBuilder, "
            + "reflectionToString method has reached the max depth calls! Please verify the circular references]";

    private final Object object;

    public ObjectsToStringBuilder(final Object object) {
        this.object = object;
    }

    @Override
    public String build(final boolean ignoreSuperType, final Style style) {
        if (object == null) {
            return "Object=null ";
        }
        final StringBuilder builder = new StringBuilder();
        if (DepthController.isAllowed(object)) {
            if (isArray(object)) {
                builder.append(new ArraysToStringBuilder(object).build());
            } else if (isWrapper(object)) {
                builder.append(OPEN_SQUARE_BRACKET);
                builder.append(object);
                builder.append(CLOSE_SQUARE_BRACKET);
            } else if (isCollection(object)) {
                builder.append(new CollectionToStringBuilder(Collection.class.cast(object)).build());
            } else if (isMap(object)) {
                builder.append(new MapToStringBuilder(Map.class.cast(object)).build());
            } else {
                builder.append(object.getClass().getSimpleName());
                builder.append(OPEN_SQUARE_BRACKET);
                builder.append(toStringFields(object, ignoreSuperType, style));
                builder.delete(builder.length() - 2, builder.length());
                builder.append(CLOSE_SQUARE_BRACKET);
            }
        } else {
            builder.append(OPEN_SQUARE_BRACKET);
            builder.append("toStringError=").append(TO_MANY_TO_STRING_CALLS_VIOLATION);
            builder.append(CLOSE_SQUARE_BRACKET);
        }
        return builder.toString();
    }

    private String toStringFields(final Object object, final boolean ignoreSuperType, final Style style) {
        StringBuilder builder = new StringBuilder();
        Field[] fields = ignoreSuperType ? object.getClass().getDeclaredFields() : extractSuperClassFields(object);
        for (Field field : fields) {
            if (isToPrintField(field)) {
                Style selectedStyle = selectStyle(style, field);
                KeyValueAppender.of(builder).appendKeyValue(object, field, selectedStyle);
            }
        }
        return builder.toString();
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
        if (hasSuperType(o)) {
            Field[] superFields = o.getClass().getSuperclass().getDeclaredFields();
            List<Field> fields = new ArrayList<>();
            for (Field field : superFields) {
                if (isNotOn(classFields, field)) {
                    fields.add(field);
                }
            }
            if (fields.isEmpty()) {
                return classFields;
            } else {
                Collections.addAll(fields, classFields);
                return fields.toArray(new Field[]{});
            }
        } else {
            return classFields;
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
