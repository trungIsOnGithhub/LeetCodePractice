public class RecentCounter {
    protected int durationInPast;
    protected IList<int> record;

    private int lowerBound(int lastTimestamp) {
        int result = -1;
        int lo = 0, hi = record.Count-1;

        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;

            if(record[mid] < lastTimestamp) {
                lo = mid+1;
            }
            else {
                result = mid;
                hi = mid-1;
            }
        }

        return result;
    }

    public RecentCounter() {
        durationInPast = 3000;
        record = new List<int>();
    }
    
    public int Ping(int t) {
        int lastTimestamp = t-durationInPast;

        record.Add(t);

        int indexOfLastPingSince = lowerBound(lastTimestamp);

        // Console.WriteLine(lastTimestamp + "  " + record.Count + "  " + indexOfLastPingSince);

        if(record.Count == 0 || indexOfLastPingSince < 0) {
            return 0;
        }

        return record.Count - indexOfLastPingSince;
    }
}