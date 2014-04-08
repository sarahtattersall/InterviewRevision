package com.st809.interview.questions;

/**
 * I wrote a crawler that visits web pages, stores a few keywords in a database, and follows links to other web pages.
 * I noticed that my crawler was wasting a lot of time visiting the same pages over and over, so I made a hash table
 * visited where I'm storing URLs I've already visited. Now the crawler only visits a URL if it hasn't already
 * been visited.
 * Thing is, the crawler is running on my old desktop computer in my parents' basement (where I totally don't live
 * anymore), and it keeps running out of memory because visited is getting so huge. How can I trim down the amount of
 * space taken up by visited?
 */
public class Crawler {
    /**
     * I first thought about hashing the whole URL and then using a bitvector for the location set to 0/1
     * Given that the size is so large its very very unlikely to have collisions.
     *
     * But then when getting an answer it said:
     * The strategy I came up with doesn't take a hit on runtime.
     * Replacing common substrings like ".com" and "www" with characters that aren't allowed in URLs
     * definitely wins us something, but we can do even better. How can we even further exploit overlaps or
     * shared prefixes between URLs?
     *
     * Well this leads me to believe a trie implementation is the best!
     * This was the answer :)
     *
     * He adds: If you used a bloom filter, that's a great answer too. Especially if you use run-length encoding.
     */
}
