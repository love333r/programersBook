package chapter01.Phone;

public class PhoneNumber {
    public final String phoneNumber;

    public PhoneNumber(String rawPhoneNumber) {
        this.phoneNumber = rawPhoneNumber.replaceAll("[^0-9]", "");
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "phoneNumber='" + phoneNumber + '\'' +
                "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PhoneNumber)) return false;
        return phoneNumber.equals(((PhoneNumber) obj).phoneNumber);
    }
}
