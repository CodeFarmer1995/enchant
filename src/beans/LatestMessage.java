package beans;

/**
 * Created by Jack on 2017-06-07.
 */
public class LatestMessage {
    private String remoteID;   //
    private String remoteName; //
    private String lastMessage; //
    private String lastTime; //

    public LatestMessage(String remoteID, String remoteName, String lastMessage, String lastTime) {
        this.remoteID = remoteID;
        this.remoteName = remoteName;
        this.lastMessage = lastMessage;
        this.lastTime = lastTime;
    }

    public String getRemoteID() {
        return remoteID;
    }

    public void setRemoteID(String remoteID) {
        this.remoteID = remoteID;
    }

    public String getRemoteName() {
        return remoteName;
    }

    public void setRemoteName(String remoteName) {
        this.remoteName = remoteName;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }
}
