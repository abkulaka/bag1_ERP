public class Attendance {
    private int lateHours;
    private int absentDays;

    public Attendance(int lateHours, int absentDays) {
        this.lateHours = lateHours;
        this.absentDays = absentDays;
    }

    public int getLateHours() {
        return lateHours;
    }

    public int getAbsentDays() {
        return absentDays;
    }
}
