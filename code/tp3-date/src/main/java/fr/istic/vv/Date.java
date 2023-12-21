package fr.istic.vv;

class Date implements Comparable<Date> {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        if (isValidDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            throw new IllegalArgumentException("La date entrée n'est pas valide.");
        }
    }

    public static boolean isValidDate(int day, int month, int year) {
        if (0 < month && month < 13) {
            int monthLength = monthLength(month, year);
            if (0 < day && day < monthLength) {
                return true;
            }
        }

        return false;
    }

    private static int monthLength(int month, int year) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else if (month == 2) {
            if (isLeapYear(year)) {
                return 29;
            } else {
                return 28;
            }
        } else {
            return -1;
        }
    }

    public static boolean isLeapYear(int year) { return year % 400 == 0 || ( year % 4 == 0 && year % 100 != 0 ); }

    public Date nextDate() {
        Date nextDate = new Date(day, month, year);

        int monthLength = monthLength(month, year);

        if (nextDate.day < monthLength) {
            nextDate.day++;
        } else if (month < 12) {
            nextDate.month++;
            nextDate.day = 1;
        } else {
            nextDate.year++;
            nextDate.month = 1;
            nextDate.day = 1;
        }

        return nextDate;
    }

    public Date previousDate() {
        Date nextDate = new Date(day, month, year);

        if (2 < nextDate.day) {
            nextDate.day--;
        } else {
            if (2 < month) {
                nextDate.month--;
                nextDate.day = monthLength(nextDate.month, nextDate.year);
            } else {
                nextDate.year--;
                nextDate.month = 12;
                nextDate.day = 31;
            }
        }

        return nextDate;
    }

    public int compareTo(Date other) {
        if (other.year < year) {
            return 1;
        } else if (year < other.year) {
            return -1;
        } else {
            if (other.month < month) {
                return 1;
            } else if (month < other.month) {
                return -1;
            } else {
                return Integer.compare(day, other.day);
            }
        }
    }

}