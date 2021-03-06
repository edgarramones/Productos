package com.producto.constant;

/**
 * Define las constantes asociadas a los estatus, utilizadas a través de la
 * aplicación.
 *
 * @author eramones
 */

public abstract class StatusConstants {

	private  StatusConstants() {
		throw new IllegalStateException();
	}

	// -----------------------------------------------------------------------------------------------------------------
	// -------------------------------------- CRETAE
	// ---------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------
	public static final String STATUS_CREATE_NOMBRE = "CREATE";

	// -----------------------------------------------------------------------------------------------------------------
	// -------------------------------------- UPDATE
	// ---------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------
	public static final String STATUS_UPDATE_NOMBRE = "UPDATE";

}
