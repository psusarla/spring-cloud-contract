import org.springframework.cloud.contract.spec.Contract
Contract.make {
    description "should create a book"
    request{
        method POST()
        url("/book")
        body(
                name: "Twilight",
                author: "Stephenie Meyer"
        )
        headers {
            header 'Content-Type': applicationJson()
        }
    }
    response {
        status 200
        body(
                id: $(anyNumber()),
                name: "Twilight",
                author: "Stephenie Meyer"
        )
        headers {
            header 'Content-Type': applicationJson()
        }
    }
}