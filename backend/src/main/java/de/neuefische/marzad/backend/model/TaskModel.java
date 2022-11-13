package de.neuefische.marzad.backend.model;

public record TaskModel (
        int id,
        String description,
        Status status
) {}
