package basicas;

public enum EnumStatus {	
	ABERTA(1L, "Aberta"),
	FECHADA(2L, "Fechada"),
	EXPIRADA(3L, "Expirada");

    private java.lang.String name;

    private java.lang.Long id;

    EnumStatus (Long id, java.lang.String name) {
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
