/**
 * Copyright 2011 Michele Andreoli
 * 
 * This file is part of UnkleBill.
 *
 * UnkleBill is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * UnkleBill is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with UnkleBill; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 **/

package executor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import boundary.ErrorLog;

/**
 * An OutputStream that writes contents to a Logger upon each call to flush()
 */
class LoggingOutputStream extends ByteArrayOutputStream {
    
    private String lineSeparator;
    
    private Logger logger = null;
    private Level level = null;
    private ErrorLog er = null;
    private String oldRecord = null;
    
    /**
     * Constructor
     * @param logger Logger to write to
     * @param level Level at which to write the log message
     */
    public LoggingOutputStream(Logger logger, Level level) {
        super();
        this.logger = logger;
        this.level = level;
        lineSeparator = System.getProperty("line.separator");        
    }
    
    /**
     * upon flush() write the existing contents of the OutputStream to the logger as 
     * a log record.
     * @throws java.io.IOException in case of error
     */
    public void flush() throws IOException {
    	
        String record;
        synchronized(this) {
            super.flush();
            record = this.toString();
            super.reset();
        }
        
        if (record.length() == 0 || record.equals(lineSeparator)) {
            return;
        }

        logger.logp(level, "", "", record);
        oldRecord += record;
        if (this.er == null)
        	this.er = new ErrorLog(oldRecord);
        else {        	
        	this.er.setErrorText(oldRecord);
        }
    }
}