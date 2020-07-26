import org.springframework.cloud.contract.spec.Contract
Contract.make {
    description "should return book for id 1"
    request{
        method GET()
        url("/book/1")
    }
    response {
        body(
                id: 1,
                name: $(anyNonBlankString()),
                author: $(anyNonBlankString())
        )
        status 200
        headers {
            header 'Content-Type': applicationJson()
        }
    }
}