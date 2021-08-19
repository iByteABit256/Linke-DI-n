package com.project.linkedin.Proffessional;

class ProffessionalNotFoundException extends RuntimeException {

    ProffessionalNotFoundException(Long id) {
        super("Could not find proffessional" + id);
    }
}