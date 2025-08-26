package com.krtec.econet.controllers.global;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class BaseCrudController<T, ID> {

    protected abstract JpaRepository<T, ID> getRepository();

    @GetMapping
    @Operation(summary = "Lista todos os registros")
    public ResponseEntity<List<T>> findAll() {
        return ResponseEntity.ok(this.getRepository().findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna os dados da entidade", parameters = {@Parameter(name = "id", description = "Chave da entidade")})
    public ResponseEntity<T> findById(@PathVariable ID id) {
        Optional<T> entity = this.getRepository().findById(id);
        return entity.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(
            summary = "Cria um novo registro da entidade",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Dados da nova entidade",
                    required = true
            )
    )
    public ResponseEntity<T> create(@RequestBody T input) {
        return ResponseEntity.ok(this.getRepository().save(input));
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Atualiza os dados de uma entidade existente",
            parameters = {@Parameter(name = "id", description = "Chave da entidade")},
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Dados da nova entidade",
                    required = true
            )
    )
    public ResponseEntity<T> update(@PathVariable ID id, @RequestBody T input) {
        if (!this.getRepository().existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(this.getRepository().save(input));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Apaga o registro da entidade", parameters = {@Parameter(name = "id", description = "Chave da entidade")})
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        if (!this.getRepository().existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        this.getRepository().deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
