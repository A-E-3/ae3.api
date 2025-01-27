/**
 *
 */
package ru.myx.ae3;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.management.ManagementFactory;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseObject;

/** @author myx */
public final class Engine extends AbstractSAPI {
	
	/** Uses low-resolution polled time, suitable to measure long periods, like 20 second timeouts
	 * 8-)
	 *
	 * A Date object whose getTime() method returns current time. setTime() calls just ignored. */
	public static final Date CURRENT_TIME;
	
	private static final MessageDigest DIGEST;
	
	/** "devel".equals(GROUP_NAME); */
	public static final boolean GROUP_DEVEL;
	
	/** "live".equals(GROUP_NAME); */
	public static final boolean GROUP_LIVE;
	
	/** Group type name, i.e. live */
	public static final String GROUP_NAME;
	
	/** "test".equals(GROUP_NAME); */
	public static final boolean GROUP_TEST;
	
	static final AbstractEngineImpl.GuidFactory GUID_GENERATOR;
	
	/** toString method will always return new GUID */
	public static final Object GUID_PRODUCER;
	
	/** as opposed to speed - compactness explicitly wanted here */
	public static final boolean MODE_SIZE;
	
	/** as opposed to speed - speed even when leads to bloat explicitly wanted here */
	public static final boolean MODE_SPEED;
	
	/** Instance host name, i.e. live.agava.myx.co.nz */
	public static final String HOST_NAME;
	
	/** The minimal number of asynchronous execution units to gain performance. This number
	 * guaranteed to be the power of 2.<br>
	 * Source: number of available processors <br>
	 * Allows static access to some parameters whose values are defaults or explicitly specified by
	 * a user and should be considered if possible. */
	public static final int PARALLELISM;
	
	/**
	 *
	 */
	public static final File PATH_CACHE;
	
	/**
	 *
	 */
	public static final File PATH_LOGS;
	
	/**
	 *
	 */
	public static final File PATH_PRIVATE;
	
	/**
	 *
	 */
	public static final File PATH_PROTECTED;
	
	/**
	 *
	 */
	public static final File PATH_PUBLIC;
	
	/**
	 *
	 */
	public static final File PATH_SHARED;
	
	/**
	 *
	 */
	public static final File PATH_TEMP;
	
	/**
	 *
	 */
	public static final File PATH_USER_DIR;
	
	/**
	 *
	 */
	public static final File PATH_USER_HOME;
	
	static final AbstractEngineImpl.RandFactory RAND_GENERATOR;
	
	/**
	 *
	 */
	public static final long STARTED = System.currentTimeMillis();
	
	/** GMT time zone */
	public static final TimeZone TIMEZONE_GMT = TimeZone.getTimeZone("GMT");
	
	/** Version string */
	public static final int VERSION_NUMBER;
	
	/** Version string */
	public static final String VERSION_STRING;
	
	static {
		{
			@SuppressWarnings("resource")
			final FileOutputStream out = new FileOutputStream(FileDescriptor.out);
			final PrintStream output = new StdOutput(Engine.STARTED, out, true);
			System.setOut(output);
		}
		
		{
			final String name = System.getProperty("ru.myx.ae3.properties.groupname", "live").toLowerCase();
			GROUP_NAME = name;
			GROUP_LIVE = "live".equals(name);
			GROUP_TEST = "test".equals(name);
			GROUP_DEVEL = "devel".equals(name);
		}
		
		{
			final String mode = System.getProperty("ru.myx.ae3.properties.optimize", "default").toLowerCase();
			MODE_SIZE = "size".equalsIgnoreCase(mode);
			MODE_SPEED = "speed".equalsIgnoreCase(mode);
		}
		
		{
			final int CPUs = Runtime.getRuntime().availableProcessors();
			/** Make it power of two (for bitwise masks) */
			PARALLELISM = (int) Math.pow(2, Math.floor(Math.log(CPUs) / Math.log(2)));
		}
		
		try {
			DIGEST = (MessageDigest) MessageDigest.getInstance("MD5").clone();
		} catch (final NoSuchAlgorithmException e) {
			throw new RuntimeException("MD5 support is required!");
		} catch (final CloneNotSupportedException e) {
			throw new RuntimeException("MD5 support for cloning is required!");
		}
		
		HOST_NAME = Engine.getHostName();
		
		try {
			{
				PATH_USER_DIR = new File(System.getProperty("user.dir")).getCanonicalFile();
			}
			{
				PATH_USER_HOME = new File(System.getProperty("user.home")).getCanonicalFile();
			}
			
			{
				final String pathDefault = Engine.PATH_USER_DIR.getPath();
				PATH_PUBLIC = new File(System.getProperty("ru.myx.ae3.properties.path.public", pathDefault)).getCanonicalFile();
			}
			{
				final String pathDefault = new File(new File(Engine.PATH_USER_HOME, ".ae3"), "protected").getCanonicalPath();
				PATH_PROTECTED = new File(System.getProperty("ru.myx.ae3.properties.path.protected", pathDefault)).getCanonicalFile();
			}
			{
				final String pathDefault = new File(new File(Engine.PATH_USER_HOME, ".ae3"), "private").getCanonicalPath();
				PATH_PRIVATE = new File(System.getProperty("ru.myx.ae3.properties.path.private", pathDefault)).getCanonicalFile();
			}
			{
				final String pathDefault = new File(new File(Engine.PATH_USER_HOME, ".ae3"), "shared").getCanonicalPath();
				PATH_SHARED = new File(System.getProperty("ru.myx.ae3.properties.path.shared", pathDefault)).getCanonicalFile();
			}
			{
				final String pathDefault = new File(Engine.PATH_PRIVATE, "cache").getCanonicalPath();
				PATH_CACHE = new File(System.getProperty("ru.myx.ae3.properties.path.cache", pathDefault)).getCanonicalFile();
			}
			{
				final String pathDefault = new File(Engine.PATH_PRIVATE, "logs").getCanonicalPath();
				PATH_LOGS = new File(System.getProperty("ru.myx.ae3.properties.path.logs", pathDefault)).getCanonicalFile();
			}
			{
				final String pathDefault = new File(Engine.PATH_PRIVATE, "temp").getCanonicalPath();
				PATH_TEMP = new File(System.getProperty("ru.myx.ae3.properties.path.temp", pathDefault)).getCanonicalFile();
			}
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
		
		Engine.PATH_PROTECTED.mkdirs();
		Engine.PATH_PRIVATE.mkdirs();
		Engine.PATH_SHARED.mkdirs();
		Engine.PATH_CACHE.mkdirs();
		Engine.PATH_LOGS.mkdirs();
		Engine.PATH_TEMP.mkdirs();
		
		System.setProperty("java.io.tmpdir", Engine.PATH_TEMP.getPath());
		
		/** this block should go last */
		{
			final AbstractEngineImpl impl = AbstractSAPI.createObject("ru.myx.ae3.ImplementEngine");
			GUID_GENERATOR = impl.GUID_GENERATOR;
			GUID_PRODUCER = impl.GUID_GENERATOR.producer();
			RAND_GENERATOR = impl.RAND_GENERATOR;
			CURRENT_TIME = impl.TIME_RETRIEVER.date();
			
			VERSION_NUMBER = 679;
			
			final String version = impl.getVersion();
			VERSION_STRING = (version == null
				? String.valueOf(Engine.VERSION_NUMBER)//
				: version.contains(String.valueOf(Engine.VERSION_NUMBER))
					? version//
					: String.valueOf(Engine.VERSION_NUMBER) + " (" + version + ')' //
			).intern();
			
			impl.start();
		}
	}
	
	private static final String getHostName() {
		
		final String parameter = System.getProperty("ru.myx.ae3.properties.hostname", "").trim();
		if (parameter.length() > 0) {
			return parameter;
		}
		try {
			return InetAddress.getLocalHost().getHostName();
		} catch (final UnknownHostException e) {
			return null;
		}
	}
	
	/** GUID is a sequence of characters used for a distinct identification of any object in a
	 * globally accessible, concurrently modifiable space for a long term life.
	 * <p>
	 *
	 * General contract is: <br>
	 * <li>GUID length MUST NOT to be less than 16 characters and more than 32 characters</li>
	 * <li>Every character in GUID sequence is either a digit, small english letter or an underline
	 * symbol '_'.</li>
	 * <li>There SHOULD NOT ever be two guid generations with the same guid as a result</li>
	 *
	 * @return newly generated guid */
	public static final String createGuid() {
		
		return Engine.GUID_GENERATOR.guid();
	}
	
	/** @param file
	 * @param environment
	 * @param folder
	 * @return */
	public static final Process createProcess(final String file, final BaseObject environment, final File folder) {
		
		final ProcessBuilder builder = new ProcessBuilder();
		builder.inheritIO();
		if (environment != null) {
			for (final Iterator<String> iterator = Base.keys(environment); iterator.hasNext();) {
				final String key = iterator.next();
				builder.environment().put(key, Base.getString(environment, key, ""));
			}
		}
		if (folder != null) {
			builder.directory(folder);
		}
		final List<Exception> exceptions = new ArrayList<>(5);
		{
			/** Try itself */
			builder.command(file);
			try {
				return builder.start();
			} catch (final Exception e) {
				exceptions.add(e);
			}
		}
		{
			/** Try unix 1 way */
			builder.command("see", file);
			try {
				return builder.start();
			} catch (final Exception e) {
				exceptions.add(e);
			}
		}
		{
			/** Try unix 1 way */
			builder.command("xdg-open", file);
			try {
				return builder.start();
			} catch (final Exception e) {
				exceptions.add(e);
			}
		}
		{
			/** Try unix 2 way */
			builder.command("gnome-open", file);
			try {
				return builder.start();
			} catch (final Exception e) {
				exceptions.add(e);
			}
		}
		{
			/** Try normal mac way */
			builder.command("open", file);
			try {
				return builder.start();
			} catch (final Exception e) {
				exceptions.add(e);
			}
		}
		{
			/** Try windows way */
			builder.command("cmd", "/c", "start " + file.replace(" ", "\" \""));
			try {
				return builder.start();
			} catch (final Exception e) {
				exceptions.add(e);
			}
		}
		{
			/** Try itself */
			builder.command(file);
			try {
				return builder.start();
			} catch (final Exception e) {
				exceptions.add(e);
			}
		}
		System.err.println("ERROR, was unable to start process, here are all errors: " + exceptions);
		return null;
	}
	
	/** @return newly generated random number */
	public static final int createRandom() {
		
		/** current rand generator is not doing proper distribution for 'long' type */
		return (int) Engine.RAND_GENERATOR.rand();
	}
	
	/** Returns random integer value in a range 0..(max-1)
	 *
	 * @param max
	 * @return int */
	public static final int createRandom(final int max) {
		
		return (int) ((Engine.RAND_GENERATOR.rand() & 0x7FFFFFFFFFFFFFFFL) % max);
	}
	
	/** @return newly generated random number, from 0.0 to 1.0 */
	public static final double createRandomDouble() {
		
		/** current rand generator is not doing proper distribution for 'long' type */
		return new BigDecimal(Engine.createRandomLong())//
				.abs()//
				.divide(new BigDecimal(Long.MAX_VALUE), 20, RoundingMode.FLOOR)//
				.doubleValue();
	}
	
	/** @return newly generated random number, whole range of Long. */
	public static final long createRandomLong() {
		
		/** current rand generator is not doing proper distribution for 'long' type */
		return (int) Engine.RAND_GENERATOR.rand() ^ Engine.RAND_GENERATOR.rand() << 32;
	}
	
	/** Returns current time. It's normal for the value returned by this method to be more discreet
	 * that real-time system clocks but in any case it should change at least once per second. This
	 * value is recommended to use in some statistics algorithms, cache expiration calculation and
	 * any other places where millisecond resolution is not significant.
	 *
	 * @return */
	public static final long fastTime() {
		
		return Engine.CURRENT_TIME.getTime();
	}
	
	/** @return */
	public static final String getInstanceId() {
		
		return ManagementFactory.getRuntimeMXBean().getName();
	}
	
	/** @return digest */
	public static final MessageDigest getMessageDigestInstance() {
		
		try {
			return (MessageDigest) Engine.DIGEST.clone();
		} catch (final CloneNotSupportedException e) {
			throw new RuntimeException("Error creating new message digest", e);
		}
	}
	
	/** literally:
	 *
	 * System.currentTimeMillis() - Engine.STARTED
	 *
	 * @return */
	public static final long getUptimeMillis() {
		
		return System.currentTimeMillis() - Engine.STARTED;
	}
	
	private Engine() {
		
		// empty
	}
}
