package dol.buddy.addicted;

import lombok.extern.slf4j.Slf4j;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Slf4j
public class BuddyFinalizer {

    private static final ConcurrentMap<String, PhantomReference<Buddy>> cache = new ConcurrentHashMap<>();
    private final ReferenceQueue<Buddy> referenceQueue;

    public BuddyFinalizer(ReferenceQueue<Buddy> referenceQueue) {
        this.referenceQueue = referenceQueue;
    }

    public void addBuddyToCache(String key, Buddy buddy) {
        cache.put(key, new PhantomReference<>(buddy, referenceQueue));
    }

    @Verify
    public void cleanUpBuddyCache() {
        Reference<? extends Buddy> ref;
        while ((ref = referenceQueue.poll()) != null) {
            cache.remove(((PhantomReference<Buddy>) ref).get());
        }
    }

}

