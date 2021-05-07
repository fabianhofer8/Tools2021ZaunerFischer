import java.util.Scanner;

public class DayCalc {
    private static final int FROM_YEAR = 1900;
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        System.out.println("Startdatum:");
        System.out.println("===========");

        System.out.print("Tag: ");
        int dayStart = in.nextInt();

        System.out.print("Monat: ");
        int monthStart = in.nextInt();

        System.out.print("Jahr: ");
        int yearStart = in.nextInt();

        System.out.println("Enddatum:");
        System.out.println("=========");

        System.out.print("Tag: ");
        int dayEnd = in.nextInt();

        System.out.print("Monat: ");
        int monthEnd = in.nextInt();

        System.out.print("Jahr: ");
        int yearEnd = in.nextInt();

        System.out.println("Tage zwischen den Daten:");
        System.out.println("=========================");

        int diffStart = calcDays(dayStart, monthStart, yearStart);
        int diffEnd = calcDays(dayEnd, monthEnd, yearEnd);
        System.out.println(Math.abs(diffEnd - diffStart));
        String cool = "Michael was here";
        in.close();
    }

    private static int calcDays(int day, int month, int year) throws Exception {
        int countGapYears = ((year - 1) / 4 - 474) - ((year - 1) / 100 - 18) + ((year - 1) / 400 - 4);
        int years = year - FROM_YEAR;

        int sumDayInMonth = 0;
        for (int i = 1; i < month; i++) {
            sumDayInMonth += getMonthDays(i, year);
        }

        if (day > getMonthDays(month, year)) {
            throw new Exception("wrong day: " + day);
        }

        if (year % 4 == 0 && !(year % 100 == 0 && year % 400 != 0)) {
            sumDayInMonth++;
        }


        return years * 365 + countGapYears + sumDayInMonth + day;
    }

    private static int getMonthDays(int month, int year) throws Exception {
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12:
                return 31;
            case 2:
                if (year % 4 == 0 && !(year % 100 == 0 && year % 400 != 0)) {
                    return 29;
                } else {
                    return 28;
                }
            case 4, 6, 9, 11:
                return 30;
            default:
                throw new Exception("wrong month: " + month);
        }
    }

    public void thisIsANewMethod() {
        // 3 is the wrong number here
        double x = 5 / 2;
        String even_cooler = "Tobias was here";
    }
}
