package org.brebu.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.brebu.messenger.database.DatabaseClass;
import org.brebu.messenger.model.Profile;

public class ProfileService {

    private Map<String, Profile> profiles = DatabaseClass.getProfiles();

    public ProfileService() {
        profiles.put("brebu", new Profile(1L, "brebu", "Ciprian", "Brebu"));
        profiles.put("xywex", new Profile(2L, "xywex", "Xywex", "Xymquian"));
    }

    public List<Profile> getAllProfiles() {
        return new ArrayList<Profile>(profiles.values());
    }

    public Profile getProfile(String profileName) {
        return profiles.get(profileName);
    }

    public Profile addProfile(Profile profile) {
        profile.setId(profiles.size() + 1);
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile updateProfile(Profile profile) {
        if (profile.getProfileName().isEmpty()) {
            return null;
        }
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile removeProfile(String profileName) {
        return profiles.remove(profileName);
    }

}
