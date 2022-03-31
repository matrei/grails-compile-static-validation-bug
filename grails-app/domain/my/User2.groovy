package my

class User2 {

    String name
    Status status

    static constraints = {
        name blank: false, minSize: 5, maxSize: 10
    }

    enum Status { ACTIVE, INACTIVE, UNKNOWN }
}
