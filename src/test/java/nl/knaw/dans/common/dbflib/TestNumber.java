/*
 *  Copyright 2009
 *  Data Archiving and Networked Services (DANS), Netherlands.
 *
 *  This file is part of DANS DBF Library.
 *
 *  DANS DBF Library is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  DANS DBF Library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with DANS DBF Library.  If not, see <http://www.gnu.org/licenses/>.
 */
package nl.knaw.dans.common.dbflib;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Tests reading and writing number values.
 *
 * @author Jan van Mansum
 */
public class TestNumber
{
    /**
     * Tests reading fields with the maximum and minimum lengths and decimal count respectively.
     *
     * @throws IOException if an I/O Exception occurs.
     * @throws CorruptedTableException if the table is corrupt (which it should not be).
     */
    @Test
    public strictfp void reading_maximal_and_minimal_values()
                                                     throws IOException, CorruptedTableException
    {
        final Table number = new Table(new File("src/test/resources/dbase3plus/types/NUMBER.DBF"));

        try
        {
            number.open();

            final List<Record> records = UnitTestUtil.createSortedRecordList(number.recordIterator(),
                                                                             "ID");

            final Record r0 = records.get(0);
            assertNull(r0.getValue("ID"));
            assertNull(r0.getValue("MININT"));
            assertNull(r0.getValue("MAXINT"));
            assertNull(r0.getValue("MAXDEC"));
            assertNull(r0.getValue("MINDEC"));

            final Record r1 = records.get(1);
            assertEquals(1,
                         r1.getNumberValue("ID").intValue());
            assertEquals(1,
                         r1.getNumberValue("MININT").intValue());
            assertEquals(1111111111111111040L,
                         r1.getNumberValue("MAXINT").longValue());
            assertEquals(111.1111111111111,
                         r1.getNumberValue("MAXDEC").doubleValue(),
                         0.0);
            assertEquals(1.1,
                         r1.getNumberValue("MINDEC").doubleValue(),
                         0.0);

            final Record r2 = records.get(2);
            assertEquals(2,
                         r2.getNumberValue("ID").intValue());
            assertEquals(2,
                         r2.getNumberValue("MININT").intValue());
            assertEquals(2222222222222222080L,
                         r2.getNumberValue("MAXINT").longValue());
            assertEquals(222.2222222222222,
                         r2.getNumberValue("MAXDEC").doubleValue(),
                         0.0);
            assertEquals(2.2,
                         r2.getNumberValue("MINDEC").doubleValue(),
                         0.0);

            final Record r3 = records.get(3);
            assertEquals(3,
                         r3.getNumberValue("ID").intValue());
            assertEquals(3,
                         r3.getNumberValue("MININT").intValue());
            assertEquals(3333333333333332992L,
                         r3.getNumberValue("MAXINT").longValue());
            assertEquals(333.33333333333334,
                         r3.getNumberValue("MAXDEC").doubleValue(),
                         0.0);
            assertEquals(3.3,
                         r3.getNumberValue("MINDEC").doubleValue(),
                         0.0);

            final Record r4 = records.get(4);
            assertEquals(4,
                         r4.getNumberValue("ID").intValue());
            assertEquals(4,
                         r4.getNumberValue("MININT").intValue());
            assertEquals(4444444444444444160L,
                         r4.getNumberValue("MAXINT").longValue());
            assertEquals(444.4444444444444,
                         r4.getNumberValue("MAXDEC").doubleValue(),
                         0.0);
            assertEquals(4.4,
                         r4.getNumberValue("MINDEC").doubleValue(),
                         0.0);

            final Record r5 = records.get(5);
            assertEquals(5,
                         r5.getNumberValue("ID").intValue());
            assertEquals(5,
                         r5.getNumberValue("MININT").intValue());
            assertEquals(5555555555555555328L,
                         r5.getNumberValue("MAXINT").longValue());
            assertEquals(555.5555555555555,
                         r5.getNumberValue("MAXDEC").doubleValue(),
                         0.0);
            assertEquals(5.5,
                         r5.getNumberValue("MINDEC").doubleValue(),
                         0.0);

            final Record r6 = records.get(6);
            assertEquals(6,
                         r6.getNumberValue("ID").intValue());
            assertEquals(6,
                         r6.getNumberValue("MININT").intValue());
            assertEquals(6666666666666599424L,
                         r6.getNumberValue("MAXINT").longValue());
            assertEquals(666.66666666666668,
                         r6.getNumberValue("MAXDEC").doubleValue(),
                         0.0);
            assertEquals(6.6,
                         r6.getNumberValue("MINDEC").doubleValue(),
                         0.0);

            final Record r7 = records.get(7);
            assertEquals(7,
                         r7.getNumberValue("ID").intValue());
            assertEquals(7,
                         r7.getNumberValue("MININT").intValue());
            assertEquals(7777777777777777664L,
                         r7.getNumberValue("MAXINT").longValue());
            assertEquals(777.777777777779,
                         r7.getNumberValue("MAXDEC").doubleValue(),
                         0.0);
            assertEquals(7.7,
                         r7.getNumberValue("MINDEC").doubleValue(),
                         0.0);

            final Record r8 = records.get(8);
            assertEquals(8,
                         r8.getNumberValue("ID").intValue());
            assertEquals(8,
                         r8.getNumberValue("MININT").intValue());
            assertEquals(8888888888888888320L,
                         r8.getNumberValue("MAXINT").longValue());
            assertEquals(888.8888888888888,
                         r8.getNumberValue("MAXDEC").doubleValue(),
                         0.0);
            assertEquals(8.8,
                         r8.getNumberValue("MINDEC").doubleValue(),
                         0.0);

            final Record r9 = records.get(9);
            assertEquals(9,
                         r9.getNumberValue("ID").intValue());
            assertEquals(9,
                         r9.getNumberValue("MININT").intValue());
            assertEquals(9999999999999998L,
                         r9.getNumberValue("MAXINT").longValue());
            assertEquals(999.9999999999998,
                         r9.getNumberValue("MAXDEC").doubleValue(),
                         0.0);
            assertEquals(9.9,
                         r9.getNumberValue("MINDEC").doubleValue(),
                         0.0);
        }
        finally
        {
            number.close();
        }
    }
}