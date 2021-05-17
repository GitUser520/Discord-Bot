package events.birthdayEvent;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.Date;
import java.util.Map;

/**
 * Represents a birthday manager that manages members' events.birthdays
 */
public class BirthdayLog extends Writable {
    public static final String SAVE_VAL = "bdayLog";
    public static final String BDAYLOG_LOCATION = "birthdays_col";

    private final Map<String, Date> bdays;

    public BirthdayLog(Map<String, Date> log) {
        bdays = log;
    } // maps member's id to birthday

    public void addMemberBirthday(String name, Date date) {
        bdays.put(name, date);
    }

    @Override
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        JSONArray logArray = new JSONArray();
        for (Map.Entry<String, Date> entry : bdays.entrySet()) {
            JSONObject entryJSON = new JSONObject();
            entryJSON.put("id", entry.getKey());
            entryJSON.put("date", BirthdayEvent.dateToStr(entry.getValue()));
            logArray.put(entryJSON);
        }
        json.put(ACCESS_KEY, SAVE_VAL);
        return json;
    }

    @Override
    public String toString() {
        return "BirthdayLog{" +
                "bdays=" + bdays +
                '}';
    }

    public Date getDateById(String id) {
        return bdays.get(id);
    }
}
