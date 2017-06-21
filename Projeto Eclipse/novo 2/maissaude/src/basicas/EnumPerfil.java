package basicas;

public enum EnumPerfil {

    MEDICO(1L, "Médico"),
    ATENDENTE(2L, "Atendente"),
    MINISTERIO(3L, "Ministério");

    private java.lang.String name;

    private java.lang.Long id;

    EnumPerfil (Long id, java.lang.String name) {
        this.name = name;
        this.id = id;
    }

    public java.lang.String getName() {
        return name;
    }

    public java.lang.Long getId() {
        return id;
    }
}