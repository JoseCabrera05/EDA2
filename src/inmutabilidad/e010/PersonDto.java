package e010;

class PersonDto {
    private final String nombreCompleto;
    private final int edad;

    public PersonDto(String nombreCompleto, int edad) {
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }
}
