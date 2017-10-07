/*
 * Copyright (C) 2017 ppm
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.com.ppm.commons.model;

import br.com.ppm.commons.ToStringBuilder;
import br.com.ppm.commons.annotation.ToStringStyle;

/**
 *
 * @author pedrotoliveira
 */
public final class Card {

    @ToStringStyle(ToStringStyle.Style.MASK_FIELD)
    private final String ccNumber;

    @ToStringStyle(ToStringStyle.Style.MASK_FIELD)
    private final String cvv;

    public Card(String ccNumber, String cvv) {
        super();
        this.ccNumber = ccNumber;
        this.cvv = cvv;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public String getCvv() {
        return cvv;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
