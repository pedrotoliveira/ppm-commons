/*
 * Copyright (C) 2017 pedrotoliveira
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
package br.com.ppm.commons.fixtures;

import java.util.Objects;

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
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.ccNumber);
        hash = 97 * hash + Objects.hashCode(this.cvv);
        return hash;
    }

    @Override
    @SuppressWarnings("PMD")
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Card other = (Card) obj;
        if (!Objects.equals(this.ccNumber, other.ccNumber)) {
            return false;
        }
        if (!Objects.equals(this.cvv, other.cvv)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ToStringBuilder.toString(this);
    }
}
