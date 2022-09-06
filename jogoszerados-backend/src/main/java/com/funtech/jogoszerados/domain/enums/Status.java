package com.funtech.jogoszerados.domain.enums;

public enum Status {

    PADRAO(0, "VALOR_INICIAL"), TERMINADO(1, "TERMINADO"), PLATINADO(2, "PLATINADO");

    private Integer codigo;
    private String descricao;

    private Status(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public static Status toEnum(Integer cod) {
        if (cod == null){
            return null;
        }

        for (Status x : Status.values()) {
            if(cod.equals(x.getCodigo())){
                return x;
            }
        }

        throw new IllegalArgumentException("Status inválido");
    }
}
