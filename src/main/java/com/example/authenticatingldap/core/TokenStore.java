package com.example.authenticatingldap.core;

public interface TokenStore {
    /**
     * Generate a token for the given user id.
     *
     * @param aUserId The ID for of the user to generate the token for.
     * @return The generated token
     * @throws IllegalArgumentException if the user id is null.
     */
    String create (String aUserId);

    /**
     * Reurns the temporary token associated with the
     * given user id if one exists. Otherwise, returns
     * null.
     *
     * @param aUserId The id of the user to return the temporary token for.
     * @return The temporary login token associated with the user or <code>null</code>/
     */
    String get (String aUserId);
}
