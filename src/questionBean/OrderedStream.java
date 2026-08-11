package questionBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1656. 设计有序流
 */
class OrderedStream {
    private Map<Integer, String> streamMap;
    private int ptr = 1;

    public OrderedStream(int n) {
        streamMap = new HashMap<>(n);
    }

    public List<String> insert(int idKey, String value) {
        streamMap.put(idKey, value);
        List<String> result = new ArrayList<>();
        if (idKey == ptr) {
            result.add(streamMap.get(ptr));
            while (streamMap.containsKey(ptr + 1)) {
                result.add(streamMap.get(ptr + 1));
                ptr++;
            }
            ptr++;
        }
        return result;
    }
}