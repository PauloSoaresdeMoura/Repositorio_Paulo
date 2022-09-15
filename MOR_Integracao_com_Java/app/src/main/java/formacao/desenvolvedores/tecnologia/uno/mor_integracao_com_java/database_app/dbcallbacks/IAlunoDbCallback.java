package formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.dbcallbacks;

import java.util.List;

import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.tabelas.Aluno;

public interface IAlunoDbCallback {
    void getAlunoFromDB(List<Aluno> tblAluno);
}
