public class LogLine {
    private LogLevel log;
    private String message;

    public LogLine(String logLine) {
        String splitMsg = logLine.substring(1,4);
        this.message = logLine.substring(7,logLine.length());
        switch(splitMsg){
            case "TRC" :
                this.log = LogLevel.TRACE;
                break;
            case "DBG" :
                this.log = LogLevel.DEBUG;
                break;
            case "INF" :
                this.log = LogLevel.INFO;
                break;
            case "WRN" :
                this.log = LogLevel.WARNING;
                break;
            case "ERR" :
                this.log = LogLevel.ERROR;
                break;
            case "FTL" :
                this.log = LogLevel.FATAL;
                break;
            default:
                this.log = LogLevel.UNKNOWN;
                break;
        }
    }

    public LogLevel getLogLevel() {
        return this.log;
    }

    public String getOutputForShortLog() {
        String result = this.log.getLevel()+":"+this.message;
        return result;
    }
}
