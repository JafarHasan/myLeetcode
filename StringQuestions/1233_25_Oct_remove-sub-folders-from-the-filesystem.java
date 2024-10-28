package StringQuestions;

import java.util.*;

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        // In ASCII, '/' is before 'a': e.g., '/a', '/a/b', '/aa'
        // After sorting the folder array, we only need to consider if the current
        // folder is a subfolder of the previous one or not.
        Arrays.sort(folder);

        List<String> result = new ArrayList<>();

        for (String dir : folder)
            if (result.isEmpty() || !dir.startsWith(result.get(result.size() - 1) + "/"))
                result.add(dir);

        return result;
    }
}

class Solution2 {
    /// TC:O(NlogN) SC:O(1)
    public List<String> removeSubfolders(String[] folder) {
        List<String> ansList = new ArrayList<>();
        Arrays.sort(folder);
        ansList.add(folder[0]);// first always a folder bcz there is not parent of this
        for (int i = 1; i < folder.length; i++) {
            String currFolder = folder[i];
            String lastFolder = ansList.get(ansList.size() - 1);
            lastFolder += '/';

            // Check if currFolder starts with lastFolder and is immediately followed by a
            // '/'
            if (!currFolder.startsWith(lastFolder)) {
                ansList.add(currFolder);
            }
        }
        return ansList;

    }
}

class Solution3 {
    /// TC:O(NxL^2) SC:O(N)
    public List<String> removeSubfolders(String[] folder) {
        List<String> ansList = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Arrays.sort(folder);
        for (String s : folder) {
            boolean find = false;
            for (int i = s.length() - 1; i >= 0; i--) {
                // find the last occur /
                if (s.charAt(i) == '/') {
                    // find substring 0 to i and check if its already exist
                    if (set.contains(s.substring(0, i))) {
                        find = true;
                        break;
                    }
                }
            }
            if (!find) {
                ansList.add(s);
            }
            set.add(s);
        }
        return ansList;
    }
}
// folder=["/a/b/c/d","a/b/c"]; here i hv to sort bcz parent folder is given
// after child folder