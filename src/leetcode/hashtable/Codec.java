public class Codec {
    
    private Hashing o;
    private Map<String , String> urlMap;
    
    public Codec() {
        o = new Hashing(6);
        this.urlMap = new HashMap<>();
    }
    
    static class Hashing {
        
        private int hashLength;
        private final String possibleChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        private final Random rand = new Random();
        
        Hashing(int hashLength) {
            this.hashLength = hashLength;
           
        }
        
        String generateRandomHash() {
            int length = possibleChar.length();
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < this.hashLength; i++) {
                sb.append(this.possibleChar.charAt(rand.nextInt(length)));
            }
            return sb.toString();
        }
        
        String generateHashUsingFunction(String url) {
            return String.valueOf(url.hashCode());
        }
        
        
        String generateHash(String longUrl) {
            return this.generateRandomHash() + this.generateHashUsingFunction(longUrl);
        }
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String hash = o.generateHash(longUrl);
        while(this.urlMap.containsKey(hash)) {
            hash = o.generateHash(longUrl);
        }
        this.urlMap.put(hash, longUrl);
        System.out.println("http://tinyurl.com/" + hash);
        return "http://tinyurl.com/" + hash;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return this.urlMap.get(shortUrl.replace("http://tinyurl.com/", ""));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
