package io.github.penguinsfan77.vanillaimprovements.utilities;

import io.github.penguinsfan77.vanillaimprovements.references.Reference;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.FMLLog;

public class LogHelper {
	
	//Main logger
	public static void log(Level logLevel, Object object) {
        FMLLog.log(Reference.MOD_NAME, logLevel, String.valueOf(object));
    }

	//Log-level all
    public static void all(Object object) {
        log(Level.ALL, object);
    }

    //Log-level debug
    public static void debug(Object object) {
        log(Level.DEBUG, object);
    }

    //Log-level error
    public static void error(Object object) {
        log(Level.ERROR, object);
    }

	//Log-level fatal
    public static void fatal(Object object) {
        log(Level.FATAL, object);
    }

	//Log-level info
    public static void info(Object object) {
        log(Level.INFO, object);
    }

	//Log-level off
    public static void off(Object object) {
        log(Level.OFF, object);
    }

	//Log-level trace
    public static void trace(Object object) {
        log(Level.TRACE, object);
    }

	//Log-level warn
    public static void warn(Object object) {
        log(Level.WARN, object);
    }

}
