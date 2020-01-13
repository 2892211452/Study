
public class PCBUnit {
    private String pId;
    private int runtime;
    private int time;
    private int pri;
    private String state;
    private int id;
    private int complete = 0;
    private int memery;

    public PCBUnit() {
    }

    public PCBUnit(String pid, int runtime, int time, int pri, String state, int memery, int id) {
        this.id = id;
        this.pId = pid;
        this.runtime = runtime;
        this.pri = pri;
        this.state = state;
        this.time = time;
        this.memery = memery;
    }

    public int getMemery() {
        return this.memery;
    }

    public void setMemery(int memery) {
        this.memery = memery;
    }

    public String getPid() {
        return this.pId;
    }

    public void setPid(String pid) {
        this.pId = pid;
    }

    public int getRuntime() {
        return this.runtime;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getComplete() {
        if (this.runtime == 0) {
            return 0;
        } else {
            this.complete = 100 * (this.runtime - this.time) / this.runtime;
            return this.complete;
        }
    }

    public void setComplete(int complete) {
        this.complete = complete;
    }

    public int getPri() {
        return this.pri;
    }

    public void setPri(int pri) {
        this.pri = pri;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String toString() {
        return "当前处理进程：" + this.pId;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
