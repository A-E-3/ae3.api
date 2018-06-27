package ru.myx.ae3.base;

import java.util.Date;

import ru.myx.ae3.help.Format;
import ru.myx.ae3.reflect.ReflectionDisable;

/**
 * @author myx
 * 
 */
@ReflectionDisable
public class BaseWrapDate extends BaseDate {
	/**
	 * 
	 */
	private static final long	serialVersionUID	= -6765952535318984353L;
	
	/**
	 * 
	 */
	protected final Date		date;
	
	/**
	 * @param date
	 */
	public BaseWrapDate(final Date date) {
		super( date.getTime() );
		this.date = date;
	}
	
	@Override
	public boolean after(final Date when) {
		return this.date.after( when );
	}
	
	@Override
	public Date baseValue() {
		return this.date;
	}
	
	@Override
	public boolean before(final Date when) {
		return this.date.before( when );
	}
	
	@Override
	public Object clone() {
		return super.clone();
	}
	
	@Override
	public int compareTo(final Date anotherDate) {
		return this.date.compareTo( anotherDate );
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public int getDate() {
		return this.date.getDate();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public int getDay() {
		return this.date.getDay();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public int getHours() {
		return this.date.getHours();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public int getMinutes() {
		return this.date.getMinutes();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public int getMonth() {
		return this.date.getMonth();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public int getSeconds() {
		return this.date.getSeconds();
	}
	
	@Override
	public long getTime() {
		return this.date.getTime();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public int getTimezoneOffset() {
		return this.date.getTimezoneOffset();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public int getYear() {
		return this.date.getYear();
	}
	
	@Override
	public int hashCode() {
		return this.date.hashCode();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void setDate(final int date) {
		this.date.setDate( date );
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void setHours(final int hours) {
		this.date.setHours( hours );
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void setMinutes(final int minutes) {
		this.date.setMinutes( minutes );
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void setMonth(final int month) {
		this.date.setMonth( month );
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void setSeconds(final int seconds) {
		this.date.setSeconds( seconds );
	}
	
	@Override
	public void setTime(final long time) {
		this.date.setTime( time );
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void setYear(final int year) {
		this.date.setYear( year );
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public String toGMTString() {
		return this.date.toGMTString();
	}
	
	/**
	 * @return
	 */
	@Override
	public String toISOString() {
		return Format.Ecma.date( this.date );
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public String toLocaleString() {
		return this.date.toLocaleString();
	}
	
	@Override
	public String toString() {
		return Format.Compact.dateRelative( this.date );
	}
	
	/**
	 * @return
	 */
	@Override
	public String toUTCString() {
		return Format.Web.date( this.date );
	}
}
