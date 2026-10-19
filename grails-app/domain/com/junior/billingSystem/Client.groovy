
class Client {
    String name
    String email
    String cpfCnpj
    Date datecreated

    static constraints = {
        name blank : false
        email email : true, unique : true
        cpfCnpj matches : /\d{11}|\d{14}/, unique : true
    }
}
