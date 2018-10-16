package cn.zsk.common.utils;

import javax.xml.datatype.XMLGregorianCalendar;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日期处理
 * 
 * @author zsk
 *
 * @date 2016年12月21日 下午12:53:33
 */
public class DateUtils {
	/** 时间格式(yyyy-MM-dd) */
	public final static String DATE_PATTERN = "yyyy-MM-dd";
	/** 时间格式(yyyy-MM-dd HH:mm:ss) */
	public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public final static String[] weekObj=new String[]{"日","一","二","三","四","五","六"};

	public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }

    public static String format(Date date, String pattern) {
        if(date != null){
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }

    public static final int MONTH_JAN = 1;
    public static final int MONTH_FEB = 2;
    public static final int MONTH_MAR = 3;
    public static final int MONTH_APR = 4;
    public static final int MONTH_MAY = 5;
    public static final int MONTH_JUN = 6;
    public static final int MONTH_JUL = 7;
    public static final int MONTH_AUG = 8;
    public static final int MONTH_SEP = 9;
    public static final int MONTH_OCT = 10;
    public static final int MONTH_NOV = 11;
    public static final int MONTH_DEC = 12;

    public static int TIME_ROOT = 2011;

    /**
     * 获得系统时间 TODO: format:yyyy-MM-dd HH:mm:ss
     *
     * @return time
     */
    public static String getSystemTime(String format) {
        // 系统时间
        String time = "";
        SimpleDateFormat timeformat = new SimpleDateFormat(format);
        time = timeformat.format(Calendar.getInstance().getTime());// 求得本地机的系统时间;
        return time;
    }

    public static Calendar getDateFromString(String timeStr, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();
        try {
            Date date = formatter.parse(timeStr);
            calendar.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar;
    }

    /**
     * 获得系统时间 TODO: format:yyyy-MM-dd HH:mm:ss
     *
     * @return Calendar
     */
    public static Calendar getSystemTime() {
        // 系统时间
        Calendar time = Calendar.getInstance();
        time.setTime(new Date());// 求得本地机的系统时间;
        return time;
    }

    /**
     * 时间比较
     *
     * @param time1
     * @param time2
     * @return
     */
    public static boolean isDateBefore(Calendar time1, Calendar time2) {
        if (time1 != null && time2 != null) {
            return time1.getTime().before(time2.getTime());
        }
        return false;
    }

    /**
     * 时间比较
     *
     * @param time1
     * @param time2
     * @return
     */
    public static boolean isDateAfter(Calendar time1, Calendar time2) {
        if (time1 != null && time2 != null) {
            return time1.getTime().before(time2.getTime());
        }
        return false;
    }

    /**
     * 时间比较 系统时间早于输入时间
     *
     * @param date2
     * @return
     */
    public static boolean isDateBefore(String date2) {
        try {
            // 获得系统时间
            Date date1 = new Date();
            DateFormat df = DateFormat.getDateTimeInstance();
            return date1.before(df.parse(date2));
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 系统时间晚于输入时间
     *
     * @param date2
     * @return
     */
    public static boolean isDateAfter(String date2) {
        try {
            // 获得系统时间
            Date date1 = new Date();
            DateFormat df = DateFormat.getDateTimeInstance();
            return date1.after(df.parse(date2));
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 时间比较(不含日期) 系统时间早于输入时间
     *
     * @param time
     * @return
     */
    public static boolean isTimeBefore(String time) {
        String date = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dd = Calendar.getInstance().getTime();
        date = sdf.format(dd);
        return isDateBefore(date + " " + time);
    }

    /**
     * 时间比较(不含日期) 系统时间晚于输入时间
     *
     * @param time
     * @return
     */
    public static boolean isTimeAfter(String time) {
        String date = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dd = Calendar.getInstance().getTime();
        date = sdf.format(dd);
        return isDateAfter(date + " " + time);
    }

    /**
     * 时间转换 TODO：将框架时间控件获得的时间转化成自己想要的时间
     *
     * @return
     */
    public static String timeFormat(String format, String oldTime) {
        String formatTime = "";

        if (!"".equals(oldTime)) {
            try {
                SimpleDateFormat time = new SimpleDateFormat(
                        "yyyy-MM-dd HH:mm:ss");
                Date date = time.parse(oldTime);
                SimpleDateFormat timeformat = new SimpleDateFormat(format);
                formatTime = timeformat.format(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return formatTime;
    }


    public static String date2String(Calendar calendar) {
        Date date = calendar.getTime();
        SimpleDateFormat dateFormatter = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        String timeStr = dateFormatter.format(date);
        return timeStr;
    }


    public static String date2StringYMD(Calendar calendar) {
        Date date = calendar.getTime();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String timeStr = dateFormatter.format(date);
        return timeStr;
    }

    public static String date2String(Date date) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        String timeStr = dateFormatter.format(date);
        return timeStr;
    }


    public static String date2String(Date date, String fomartStr) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat(fomartStr);
        String timeStr = dateFormatter.format(date);
        return timeStr;
    }

    public static String date2String(Calendar date, String fomartStr) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat(fomartStr);
        String timeStr = dateFormatter.format(date.getTime());
        return timeStr;
    }


    public static Calendar string2Date(String timeStr) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();

        try {
            Date date = dateFormatter.parse(timeStr);
            calendar.setTime(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return calendar;
    }

    /***
     * String转换为Calendar
     *
     * @param timeStr
     *            时间字符串
     * @param formaStr
     *            匹配格式
     * @return
     */
    public static Calendar strToDate(String timeStr, String formaStr) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat(formaStr);
        Calendar calendar = Calendar.getInstance();

        try {
            Date date = dateFormatter.parse(timeStr);
            calendar.setTime(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return calendar;
    }


    public static Date stringToDate(String timeStr) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

        Date date = null;
        try {
            date = dateFormatter.parse(timeStr);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return date;
    }

    public static Date stringToDate(String timeStr,String formaStr) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat(formaStr);

        Date date = null;
        try {
            date = dateFormatter.parse(timeStr);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return date;
    }

    /**
     * 获得当前时间的前3天
     *
     */

    public static String getTimeBefore3() {
        Date myDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        long myTime = (myDate.getTime() / 1000) - 60 * 60 * 24 * 3;
        myDate.setTime(myTime * 1000);
        String mDate = formatter.format(myDate);
        return mDate;
    }

    /**
     * 获得当前时间前几天
     *
     * @param days
     *            前几天
     * @return
     */
    public static String getTimeBefore(int days, Date myDate) {
        Date testDate = myDate;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        long myTime = (testDate.getTime() / 1000) - 60 * 60 * 24 * days;
        testDate.setTime(myTime * 1000);
        String mDate = formatter.format(testDate);
        return mDate;
    }

    /**
     * 获得当前时间前几天
     *
     * @param days
     *            前几天
     * @return
     */
    public static String getTimeBefore(int days, Date myDate,String format) {
        Date testDate = myDate;
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        long myTime = (testDate.getTime() / 1000) - 60 * 60 * 24 * days;
        testDate.setTime(myTime * 1000);
        String mDate = formatter.format(testDate);
        return mDate;
    }

    /**
     * 获得当前时间前几小时的时间
     *
     * @param hour
     *            前几小时
     * @return
     */
    public static String getHourTimeBefore(int hour, Date myDate) {
        Date testDate = myDate;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long myTime = (testDate.getTime() / 1000) - 60 * 60 * hour;
        testDate.setTime(myTime * 1000);
        String mDate = formatter.format(testDate);
        return mDate;
    }

    /**
     * 获得指定时间前几天，格式yyyy-MM-dd
     *
     * @param days
     *            前几天
     * @return
     */
    public static String getTimeBefore(int days, String date) {
        Date myDate = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            myDate = formatter.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (myDate != null) {
            long myTime = (myDate.getTime() / 1000) - 60 * 60 * 24 * days;
            myDate.setTime(myTime * 1000);
            String mDate = formatter.format(myDate);
            return mDate;
        }

        return null;
    }

    public static String getTimeBeforeByFormat(int days, String date,
                                               String format) {
        Date myDate = null;
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        try {
            myDate = formatter.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (myDate != null) {
            long myTime = (myDate.getTime() / 1000) - 60 * 60 * 24 * days;
            myDate.setTime(myTime * 1000);
            String mDate = formatter.format(myDate);
            return mDate;
        }

        return null;
    }



    /**
     * XMLGregorianCalendar转String
     *
     * @param cal
     * @return
     */
    public static String xMLGregorianCalendar2String(XMLGregorianCalendar cal) {
        if (null != cal) {
            Calendar calendar = cal.toGregorianCalendar();
            String result = date2String(calendar);
            return result;
        } else {
            return null;
        }
    }

    /**
     * 字符串转为Calendar
     *
     * @param timeStr
     *            时间字符串格式为yyyy-MM-dd
     * @return
     */
    public static Calendar str2Date(String timeStr) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        try {
            Date date = dateFormatter.parse(timeStr);
            calendar.setTime(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return calendar;
    }

    /**
     * java.util.Date转java.sql.date
     */
    public static Timestamp utilDate2SqlDate(Date utildate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        formatter.format(utildate);
        java.sql.Date sqldate = new java.sql.Date(utildate.getTime());
        Timestamp result = new Timestamp(sqldate.getTime());
        return result;
    }


    public static List<String> getTjTimeList(String str_startTime,
                                             String str_endTime, String type) {
        List<String> listTjTime = new ArrayList<String>();
        // 按日统计
        if ("0".equals(type)) {
            int startYear = Integer.parseInt(str_startTime.substring(0, 4));
            int endYear = Integer.parseInt(str_endTime.substring(0, 4));
            int startMonth = Integer.parseInt(str_startTime.substring(5, 7));
            int endMonth = Integer.parseInt(str_endTime.substring(5, 7));
            int startDay = Integer.parseInt(str_startTime.substring(8));
            int endDay = Integer.parseInt(str_endTime.substring(8));
            // 开始时间
            Calendar start = Calendar.getInstance();
            start.set(startYear, startMonth - 1, startDay);
            // 结束时间
            Calendar end = Calendar.getInstance();
            end.set(endYear, endMonth - 1, endDay);
            // 日间隔数
            long rjg = (end.getTimeInMillis() - start.getTimeInMillis())
                    / (1000 * 24 * 60 * 60);
            for (int i = 0; i <= rjg; i++) {
                if (i != 0) {
                    startDay++;
                }
                switch (startMonth) {
                    case 2:
                        // 如果是闰年
                        if (startYear % 4 == 0 && startYear % 100 != 0
                                || startYear % 400 == 0) {
                            if (startDay > 29) {
                                startMonth++;
                                startDay -= 29;
                            }
                        } else {
                            if (startDay > 28) {
                                startMonth++;
                                startDay -= 28;
                            }
                        }
                        // listTjTime.add(startYear+"-0"+startMonth+"-"+(startDay>9?startDay:"0"+startDay));
                        break;
                    case 4:
                        if (startDay > 30) {
                            startMonth++;
                            startDay -= 30;
                        }
                        // listTjTime.add(startYear+"-0"+startMonth+"-"+(startDay>9?startDay:"0"+startDay));
                        break;
                    case 6:
                        if (startDay > 30) {
                            startMonth++;
                            startDay -= 30;
                        }
                        // listTjTime.add(startYear+"-0"+startMonth+"-"+(startDay>9?startDay:"0"+startDay));
                        break;
                    case 9:
                        if (startDay > 30) {
                            startMonth++;
                            startDay -= 30;
                            listTjTime.add(startYear + "-" + startMonth + "-0"
                                    + startDay);
                        } else {
                            // listTjTime.add(startYear+"-0"+startMonth+"-"+(startDay>9?startDay:"0"+startDay));
                        }
                        break;
                    case 11:
                        if (startDay > 30) {
                            startMonth++;
                            startDay -= 30;
                        } else {
                            // listTjTime.add(startYear+"-"+startMonth+"-"+(startDay>9?startDay:"0"+startDay));
                        }
                        break;
                    case 12:
                        if (startDay > 31) {
                            startYear++;
                            startMonth = 1;
                            startDay -= 31;
                        }
                        // listTjTime.add(startYear+"-"+(startMonth>9?startMonth:"0"+startMonth)+"-"+(startDay>9?startDay:"0"+startDay));
                        break;
                    default:
                        if (startDay > 31) {
                            startMonth++;
                            startDay -= 31;
                        }
                        // listTjTime.add(startYear+"-"+(startMonth>9?startMonth:"0"+startMonth)+"-"+(startDay>9?startDay:"0"+startDay));
                        break;
                }
                listTjTime.add(startYear + "-"
                        + (startMonth > 9 ? startMonth : "0" + startMonth)
                        + "-" + (startDay > 9 ? startDay : "0" + startDay));

            }

        }
        // 按月统计
        if ("1".equals(type)) {
            // 开始年
            int startYear = Integer.parseInt(str_startTime.substring(0, 4));
            // 结束年
            int endYear = Integer.parseInt(str_endTime.substring(0, 4));
            // 开始月
            int startMonth = Integer.parseInt(str_startTime.substring(5));
            // 结束月
            int endMonth = Integer.parseInt(str_endTime.substring(5));
            // 如果是同一年的
            if (startYear == endYear) {
                // 循环将从开始到结束的所有日期放到list中
                for (int i = 0; i <= endMonth - startMonth; i++) {
                    if ((startMonth + i) >= 10) {
                        listTjTime.add(startYear + "-" + (startMonth + i));
                    } else {
                        listTjTime.add(startYear + "-0" + (startMonth + i));
                    }

                }
                return listTjTime;
            } else {
                // 年跨度差值
                int ncz = endYear - startYear;
                // 通过循环先将开始那一年的日期加到list中
                for (int i = 0; i <= 12 - startMonth; i++) {
                    if ((startMonth + i) >= 10) {
                        listTjTime.add(startYear + "-" + (startMonth + i));
                    } else {
                        listTjTime.add(startYear + "-0" + (startMonth + i));
                    }
                }
                // 如果年跨度大于1
                if (ncz > 1) {
                    // 循环开始和结束中间的年数
                    for (int i = 1; i < ncz; i++) {
                        // 循环12次，将一年的时间加到list
                        for (int j = 1; j <= 12; j++) {
                            if (j >= 10) {
                                listTjTime.add((startYear + i) + "-" + j);
                            } else {
                                listTjTime.add((startYear + i) + "-0" + j);
                            }
                        }
                    }
                }
                // 通过循环将结束那一年的日期加到list中
                for (int i = 1; i <= endMonth; i++) {
                    if (i >= 10) {
                        listTjTime.add(endYear + "-" + i);
                    } else {
                        listTjTime.add(endYear + "-0" + i);
                    }

                }
                return listTjTime;
            }

        }
        // 按年统计
        if ("2".equals(type)) {
            int startYear = Integer.parseInt(str_startTime.substring(0, 4));
            int endYear = Integer.parseInt(str_endTime.substring(0, 4));
            for (int i = 0; i <= endYear - startYear; i++) {
                listTjTime.add(startYear + i + "");
            }
            return listTjTime;
        }
        return listTjTime;
    }

    /**
     * 获取当前天数是当年的第几天
     *
     * @return
     */
    public static String getCurrentDaysofYear() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String currentDay = format.format(new Date());
        return getDayIndexofYear(currentDay);
    }

    /**
     * 判断是否为闰年
     *
     * @param year
     * @return
     */
    public static boolean isLeapYear(int year) {
        // 判断是不是闰年
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            return true;
        }
        return false;
    }

    /**
     * 获得当月的天数
     *
     * @param month
     *            月份
     * @param isLeapYear
     *            是否为闰年
     * @return
     */
    public static int getDayofMonth(int month, boolean isLeapYear) {
        // 非闰年
        final int[] normal = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        // 闰年
        final int[] leapYear = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if (month != 0 && !isLeapYear) {
            return normal[month - 1];
        }
        if (month != 0 && isLeapYear) {
            return leapYear[month - 1];
        }
        return 0;
    }

    public static int getDayofYear(int year) {
        if (isLeapYear(year))
            return 366;
        return 365;
    }

    /**
     * 根据日期获取日期在当年中的天数
     *
     * @param date
     * @return
     */
    public static String getDayIndexofYear(String date) {
        int year = 0;
        int month = 0;
        int day = 0;
        String strIndex = "";
        boolean isLeapYear = false;
        int index = 0;
        if (date != null) {
            String[] timeArray = date.split("-");
            if (timeArray != null && timeArray.length > 0) {
                year = Integer.valueOf(timeArray[0]);
                month = Integer.valueOf(timeArray[1]);
                day = Integer.valueOf(timeArray[2]);

                isLeapYear = isLeapYear(year);
                for (int i = 1; i < month; i++) {
                    index += getDayofMonth(i, isLeapYear);
                }

                index += day;

                if (index < 10) {
                    strIndex = "00" + String.valueOf(index);
                } else if (index < 100 && index >= 10) {
                    strIndex = "0" + String.valueOf(index);
                } else {
                    strIndex = index + "";
                }
                return strIndex;
            }
        }

        return strIndex;
    }

    /**
     * 获取当前时间，以分钟计算
     *
     * @return
     */
    private int index = 0;

    public static Date getMondayOfThisWeek() {
        Calendar c = Calendar.getInstance();
        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0)
            day_of_week = 7;
        c.add(Calendar.DATE, -day_of_week + 1);
        return c.getTime();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public static String getMintuesFromRoot() {

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int year = cal.get(Calendar.YEAR);
        int day = 0;
        int hours = cal.get(Calendar.HOUR_OF_DAY);
        int minutes = cal.get(Calendar.MINUTE);
        int seconds = cal.get(Calendar.SECOND);

        if (year > 2020)
            TIME_ROOT = 2020;

        for (int i = TIME_ROOT; i < year; i++) {
            day += getDayofYear(i);
        }
        day += Integer.valueOf(getCurrentDaysofYear());

        minutes = day * hours * minutes;

        String mins = String.valueOf(minutes);
        String sec = String.valueOf(seconds);
        switch (mins.length()) {
            case 4:
                mins = "0".concat(mins);
            case 5:
                mins = "0".concat(mins);
            case 6:
                mins = mins.concat(sec.substring(sec.length() - 1, sec.length()));
        }
        return mins;
    }

    /**
     * 获得一个时间的前段时间
     *
     * @param days
     *            跨度
     * @param date
     *            当前时间 yyyy-MM-dd/yyyy-MM/yyyy
     * @param type
     *            类型(0日，1月，2年)
     * @return
     */
    public static String getTimeBefore(int days, String date, String type) {
        if ("0".equals(type)) {
            Date myDate = null;
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            try {
                myDate = formatter.parse(date);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (myDate != null) {
                long myTime = (myDate.getTime() / 1000) - 60 * 60 * 24 * days;
                myDate.setTime(myTime * 1000);
                String mDate = formatter.format(myDate);
                return mDate;
            }
        }
        if ("1".equals(type)) {
            try {
                int month = Integer.valueOf(date.substring(5, 7));
                int year = Integer.valueOf(date.substring(0, 4));
                if (days - month > 0) {
                    // 年跨度
                    int step = (days - month) / 12 + 1;
                    // 除去整年后的余月
                    int m = (days - month) % 12;
                    year = year - step;
                    month = 12 - m;
                } else {
                    month = month - days;
                }
                String newDate = year + "-" + (month > 9 ? month : "0" + month);
                return newDate;
            } catch (NumberFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if ("2".equals(type)) {
            int year = Integer.valueOf(date.substring(0, 4));
            String newDate = (year - days) + "";
            return newDate;
        }

        return "";
    }

    public static Calendar string2Date(String timeStr, String format) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();

        try {
            Date date = dateFormatter.parse(timeStr);
            calendar.setTime(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return calendar;
    }

    public static boolean isValidDate(String str) {
        boolean convertSuccess = true;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            format.setLenient(false);
            format.parse(str);
        } catch (ParseException e) {
            // e.printStackTrace();
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            convertSuccess = false;
        }
        return convertSuccess;
    }

    public static String getTimeAfter(int days, Date myDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar now = Calendar.getInstance();
        now.setTime(myDate);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + days);
        String mDate = formatter.format(now.getTime());
        return mDate;
    }

    public static String getMonthStr(int month) {
        if (month < 10) {
            return "0" + String.valueOf(month);
        } else {
            return  String.valueOf(month);
        }
    }

}
