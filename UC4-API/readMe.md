User Story: 4
Description: API to Create domestic scheduled payment consent

Request:
POST /domestic-scheduled-payment-consents
Content-Type: application/json
Accept: application/json

{
  "Data": {
    "Permission":"Create",
    "Initiation": {
      "RequestedExecutionDate": "2018-08-06T00:00:00+00:00",
      "InstructedAmount": {
        "Amount": "200.00",
        "Currency": "GBP"
      },
      "DebtorAccount": {
        "SchemeName": "UK.OBIE.SortCodeAccountNumber",
        "Identification": "11280001234567",
        "Name": "Andrea Frost"
      },
      "CreditorAccount": {
        "SchemeName": "UK.OBIE.SortCodeAccountNumber",
        "Identification": "08080021325698",
        "Name": "Tom Kirkman"
      },
      "RemittanceInformation": {
        "Reference": "DSR-037",
        "Unstructured": "Internal ops code 5120103"
      }
    }
  },
  "Risk": {
    "PaymentContextCode": "PartyToParty"
  }
}


Response:
HTTP/1.1 201 Created
Content-Type: application/json   
{
    "Data": {
        "ConsentId": "7290",
        "Permission": "Create",
        "Status": "AwaitingAuthorisation",
        "CreationDateTime": "2018-05-05T15:15:13+00:00",
        "StatusUpdateDateTime": "2018-05-05T15:15:13+00:00",
        "Initiation": {
            "RequestedExecutionDate": "2018-08-06T00:00:00+00:00",
            "InstructedAmount": {
                "Amount": "200.00",
                "Currency": "GBP"
            },
            "DebtorAccount": {
                "SchemeName": "UK.OBIE.SortCodeAccountNumber",
                "Identification": "11280001234567",
                "Name": "Andrea Frost"
            },
            "CreditorAccount": {
                "SchemeName": "UK.OBIE.SortCodeAccountNumber",
                "Identification": "08080021325698",
                "Name": "Tom Kirkman"
            },
            "RemittanceInformation": {
                "Reference": "DSR-037",
                "Unstructured": "Internal ops code 5120103"
            }
        }
    },
    "Risk": {
        "PaymentContextCode": "PartyToParty"
    }
}
Error Scenarios:

 1. HTTP/1.1 400 Invalid request parameter 
Content-Type: application/json; charset=utf-8 
{ 
  code: ”400” 
  message: “Invalid request parameter passed” 
}
2. HTTP/1.1 404 Not found 
Content-Type: application/json; charset=utf-8 
{ ––-––
  code: ”404” 
  message: “Not Found” 
}
3. HTTP/1.1 500 Server error 
Content-Type: application/json; charset=utf-8 
{ 
  code: ”500” 
  message: “ Opps! Something went wrong” 
}

Tables:
1.	Account
Field	Type
SchemeName	varchar(256)
Identification(PK)	varchar(256)
Name	varchar(70)
SecondaryIdentification	varchar(34)
AccountId	varchar(40)
ConsentId	varchar(128)

2.	Consents table
Field	Type
Consent_Id	varchar(128)
Creation_Date	DateTime
Status	varchar(128)
Status_update_Date	DateTime
Cut_Off_Date	DateTime 
Payment_Amount	Decimal
Payment_Currency	varchar(30)
Requested_Execution_Date	DateTime
Creditor_Id	Decimal
Debitor_Id	Decimal
Remittance_Reference	varchar(128)
Remittance_Unstructured	varchar(128)
Payment_Context	varchar(128)
Instruction_Identification	varchar(128)
End_To_End_Identification	varchar(128)
Expected_execution_Date	DateTime
Permission	varchar(128)
Frequency	varchar(128)
Reference	varchar(128)

