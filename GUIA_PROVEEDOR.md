# Guía para proveedores de la herramienta DevSecOps

Este repositorio contiene una API REST de pagos para una evaluación técnica de capacidades SAST, SCA y detección de secretos. El proveedor debe realizar la integración y configuración de su solución con sus propios procedimientos. El código de la aplicación es el punto de partida de la prueba.

## Alcance de la demostración

1. Explicar cómo se incorpora el repositorio a la plataforma y cómo se habilitan los análisis de código, dependencias y secretos.
2. Mostrar el flujo de trabajo de un desarrollador y la información que recibe para corregir hallazgos.
3. Configurar y demostrar controles para solicitudes de cambio hacia `develop` y para la revisión previa a `main`.
4. Presentar cómo se distinguen hallazgos existentes de hallazgos introducidos durante la evaluación, incluyendo el tratamiento de falsos positivos.
5. Explicar los criterios configurados para aprobar o bloquear cambios y mostrar el resultado real de esos controles.

La persona evaluadora introducirá cambios durante la sesión. El proveedor no debe modificar anticipadamente `main` ni `develop`, ni incorporar correcciones, exclusiones o reglas específicas del proyecto antes de que se acuerden en la demostración. Cualquier configuración necesaria debe quedar identificada y ser reproducible. La implementación de pipelines y compuertas corresponde íntegramente al proveedor.

## Evidencias solicitadas

- Configuración aplicada: productos o módulos habilitados, versiones, políticas, umbrales y alcance de cada análisis.
- Resultados exportables de cada ejecución: identificador, fecha, commit o PR analizado, estado, duración y hallazgos con ubicación, severidad y recomendación.
- Evidencia del resultado de los controles sobre PR, incluido el estado que observa el desarrollador y el motivo de aprobación o bloqueo.
- Registro de triage: decisiones sobre duplicados, falsos positivos y hallazgos aceptados, con su justificación.
- Limitaciones observadas, requisitos de licencia y pasos necesarios para reproducir la integración.

Los reportes y credenciales del proveedor deben mantenerse fuera del código fuente del servicio. Usar mecanismos de secretos de la plataforma correspondiente; no incluir tokens en commits, comentarios de PR ni capturas de pantalla.

## Condiciones de la evaluación

El repositorio no incluye workflows de CI/CD ni una configuración de escaneo suministrada por el cliente. No se proporciona un listado de hallazgos esperados. La evaluación se basará en la configuración que el proveedor implemente y en la evidencia que produzca sobre el código y los cambios realizados durante la sesión.
