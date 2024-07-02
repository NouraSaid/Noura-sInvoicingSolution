
    @Query("SELECT invo FROM Invoice invo WHERE invo.id = :invoId")
    public Invoice findInvoiceById(@Param("invoId") Integer invoId);
