package contracts.books

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Should return book by author"

    request {
        url "/bookByAuthor"
        method "POST"
    }

    response {
        status 200
        headers {
            contentType "application/json"
        }
        body(
                title: "Identity",
                author: "TD Jakes",
                pubYear: 2017
        )
    }
}
