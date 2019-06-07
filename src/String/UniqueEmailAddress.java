package String;

import java.util.HashSet;

/**
 * Created by Bi on 6/4/19.
 * https://leetcode.com/problems/unique-email-addresses/
 */
public class UniqueEmailAddress {
    public static void main(String[] args) {
//        String[] emails = new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
//        System.out.println(numUniqueEmails(emails));
        System.out.println("123".charAt(1) - '0');
    }

    public static int numUniqueEmails(String[] emails) {
        int len = emails.length;
        if (len == 0 || len == 1) {
            return len;
        }

        HashSet<String> uniqueEmails = new HashSet<>();

        for (String email: emails) {
            String[] temp = email.split("@");
            String localName = temp[0];
            String domainName = temp[1];
            int plusIdx = localName.indexOf("+");

            if (plusIdx != -1) {
                localName = localName.substring(0, plusIdx);
            }

            localName = localName.replaceAll("\\.","");
            String handledEmail = localName + "@" + domainName;
            uniqueEmails.add(handledEmail);
        }

        return uniqueEmails.size();
    }
}
