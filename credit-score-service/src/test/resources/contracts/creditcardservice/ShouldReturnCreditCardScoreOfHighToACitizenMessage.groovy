import org.springframework.cloud.contract.spec.Contract

Contract.make {
    label ("credit_score_of_high_contract")
    outputMessage {
        sentTo ("credit_scores")
        body (
                "score": "HIGH",
                "uuid": "9e4c2069-9643-4884-829c-abf0fbca5fea"
        )
        headers {
            contentType(applicationJsonUtf8())
        }
    }
}
