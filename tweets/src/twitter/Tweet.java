 Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 Redistribution of original or derived work requires permission of course staff.
 
witer;

v.time.Instant;

mutable datatype represents a tweet from Twitter.
 
 DO NOT CHANGE THIS CLASS.

 c Tweet {

    p final long id;
    p final String author;
    p final String text;
    p final Instant timestamp;
    
     invariant: 
         author.length > 0
         all characters in author are drawn from {A..Z, a..z, 0..9, _, -}
         text.length <= 140
     
    
    
     k  Tweet with a known unique id.
      
     m id
                 unique identifier for the tweet, as assigned by Twitter.
     m author
                 Twitter username who wrote this tweet.  
                 Required to be a Twitter username as defined by getAuthor() below.
     
    m text
     text of the tweet, at most 140 characters.
     
     m timestamp
                 date/time when the tweet was sent.
     
     Tweet(final long id, final String author, final String text, final Instant timestamp) {
        this.id = id;
        this.author = author;
        this.text = text;
        this.timestamp = timestamp;
    }

    
     turn unique identifier of this tweet
     
    public long getId() {
        turn id;
    }

    
     turn Twitter username who wrote this tweet.
          A Twitter username is a nonempty sequence of letters (A-Z or
          a-z), digits, underscore ("_"), or hyphen ("-").
          Twitter usernames are case-insensitive, so "jbieber" and "JBieBer"
          are equivalent.
     
    public String getAuthor() {
        turn author;
    }

    
     turn text of this tweet, at most 140 characters
     
    public String getText() {
        turn text;
    }

    
     turn date/time when this tweet was sent
     
    public Instant getTimestamp() {
        turn timestamp;
    }

    
     s Object.toString()
    
    de public String toString() {
        turn "(" + this.getId()
                + " " + this.getTimestamp().toString()
                + " " + this.getAuthor()
                + ") " + this.getText();
    }

    
     s Object.equals()
     
    de public boolean equals(Object thatObject) {
         (!(thatObject instanceof Tweet)) {
            return false;
        }

        wet that = (Tweet) thatObject;
        turn this.id == that.id;
    }

    /*
     * @see Object.hashCode()
     */
    @Override public int hashCode() {
        final int bitsInInt = 32;
        final int lower32bits = (int) id;
        final int upper32bits = (int) (id >> bitsInInt);
        return lower32bits ^ upper32bits;
    }
}
