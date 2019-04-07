package org.ipass.com.ipass;

/**
 * Created by Abishek on 16-Apr-18.
 */

public class ResultItems {

    private String field1Name;
    private String field2Name;
    private String field3Name;
    private String field4Name;
    private String field5Name;
    private String field6Name;
    private String field1Value;
    private String field2Value;
    private String field3Value;
    private String field4Value;
    private String field5Value;
    private String field6Value;
    private String switch1Name;
    private String switch2Name;
    private String switch3Name;
    private String switch4Name;
    private String switch5Name;
    private String switch6Name;
    private Boolean switch1State;
    private Boolean switch2State;
    private Boolean switch3State;
    private Boolean switch4State;
    private Boolean switch5State;
    private Boolean switch6State;
    private String MapName;
    private String lat;
    private String lon;
    private String time;

    public ResultItems(String time,String field1Name, String field1Value, String field2Name, String field2Value ,String field3Name, String field3Value, String field4Name,String field4Value,String field5Name,String field5Value,String field6Name,String field6Value){
        this.setField1Name(field1Name);
        this.setField1Value(field1Value);
        this.setField2Name(field2Name);
        this.setField2Value(field2Value);
        this.setField3Name(field3Name);
        this.setField3Value(field3Value);
        this.setField4Name(field4Name);
        this.setField4Value(field4Value);
        this.setField5Name(field5Name);
        this.setField5Value(field5Value);
        this.setField6Name(field6Name);
        this.setTime(time);
    }
    public String getField1Name() {
        return field1Name;
    }

    public void setField1Name(String field1Name) {
        this.field1Name = field1Name;
    }

    public String getField2Name() {
        return field2Name;
    }

    public void setField2Name(String field2Name) {
        this.field2Name = field2Name;
    }

    public String getField3Name() {
        return field3Name;
    }

    public void setField3Name(String field3Name) {
        this.field3Name = field3Name;
    }

    public String getField4Name() {
        return field4Name;
    }

    public void setField4Name(String field4Name) {
        this.field4Name = field4Name;
    }

    public String getField5Name() {
        return field5Name;
    }

    public void setField5Name(String field5Name) {
        this.field5Name = field5Name;
    }

    public String getField6Name() {
        return field6Name;
    }

    public void setField6Name(String field6Name) {
        this.field6Name = field6Name;
    }

    public String getField1Value() {
        return field1Value;
    }

    public void setField1Value(String field1Value) {
        this.field1Value = field1Value;
    }

    public String getField2Value() {
        return field2Value;
    }

    public void setField2Value(String field2Value) {
        this.field2Value = field2Value;
    }

    public String getField3Value() {
        return field3Value;
    }

    public void setField3Value(String field3Value) {
        this.field3Value = field3Value;
    }

    public String getField4Value() {
        return field4Value;
    }

    public void setField4Value(String field4Value) {
        this.field4Value = field4Value;
    }

    public String getField5Value() {
        return field5Value;
    }

    public void setField5Value(String field5Value) {
        this.field5Value = field5Value;
    }

    public String getField6Value() {
        return field6Value;
    }

    public void setField6Value(String field6Value) {
        this.field6Value = field6Value;
    }

    public String getSwitch1Name() {
        return switch1Name;
    }

    public void setSwitch1Name(String switch1Name) {
        this.switch1Name = switch1Name;
    }

    public String getSwitch2Name() {
        return switch2Name;
    }

    public void setSwitch2Name(String switch2Name) {
        this.switch2Name = switch2Name;
    }

    public String getSwitch3Name() {
        return switch3Name;
    }

    public void setSwitch3Name(String switch3Name) {
        this.switch3Name = switch3Name;
    }

    public String getSwitch4Name() {
        return switch4Name;
    }

    public void setSwitch4Name(String switch4Name) {
        this.switch4Name = switch4Name;
    }

    public String getSwitch5Name() {
        return switch5Name;
    }

    public void setSwitch5Name(String switch5Name) {
        this.switch5Name = switch5Name;
    }

    public String getSwitch6Name() {
        return switch6Name;
    }

    public void setSwitch6Name(String switch6Name) {
        this.switch6Name = switch6Name;
    }

    public Boolean getSwitch1State() {
        return switch1State;
    }

    public void setSwitch1State(Boolean switch1State) {
        this.switch1State = switch1State;
    }

    public Boolean getSwitch2State() {
        return switch2State;
    }

    public void setSwitch2State(Boolean switch2State) {
        this.switch2State = switch2State;
    }

    public Boolean getSwitch3State() {
        return switch3State;
    }

    public void setSwitch3State(Boolean switch3State) {
        this.switch3State = switch3State;
    }

    public Boolean getSwitch4State() {
        return switch4State;
    }

    public void setSwitch4State(Boolean switch4State) {
        this.switch4State = switch4State;
    }

    public Boolean getSwitch5State() {
        return switch5State;
    }

    public void setSwitch5State(Boolean switch5State) {
        this.switch5State = switch5State;
    }

    public Boolean getSwitch6State() {
        return switch6State;
    }

    public void setSwitch6State(Boolean switch6State) {
        this.switch6State = switch6State;
    }

    public String getMapName() {
        return MapName;
    }

    public void setMapName(String mapName) {
        MapName = mapName;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
