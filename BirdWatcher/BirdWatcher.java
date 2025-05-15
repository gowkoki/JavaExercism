
class BirdWatcher {
    private  int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        return birdsPerDay;
    }

    public int getToday() {
        return birdsPerDay[birdsPerDay.length-1];
    }

    public void incrementTodaysCount() {
        birdsPerDay[birdsPerDay.length-1] += 1;
    }

    public boolean hasDayWithoutBirds() {
        for(int i : birdsPerDay){
            if(i == 0){
                return true;
            }
        }
        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int sum = 0;
        int day = numberOfDays <= birdsPerDay.length ?numberOfDays : birdsPerDay.length;
        for(int i =0; i<day;i++){
            sum+=birdsPerDay[i];
        }
        return sum;
    }

    public int getBusyDays() {
        int daysCount = 0;
        for(int i : birdsPerDay){
            if(i >= 5){
                daysCount++;
            }
        }
        return daysCount;
    }
}
