import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { ApiService } from '../shared/api.service';


@Component({
  selector: 'app-update-consumer',
  templateUrl: './update-consumer.component.html',
  styleUrls: ['./update-consumer.component.css']
})
export class UpdateConsumerComponent implements OnInit {

  public consumerUpdateForm!: FormGroup
  ID: any;
  id: any;
  consumerData:any;


  CONSUMER_NAME: any;
  constructor(private formBuilder: FormBuilder, private http: HttpClient, private router: Router, private route: ActivatedRoute, private api: ApiService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    // console.log("thisis url id ", this.id)
    this.prePopulate(this.id);
    this.consumerUpdateForm = this.formBuilder.group({
      ID: ["", Validators.required],
      First_Name: ['', Validators.required],
      DOB: ['', Validators.required],
      Business_Name: ['', Validators.required],
      PAN_Details: ['', Validators.required],
      Email: ['', Validators.required],
      Phone: ['', Validators.required],
      Website: ['', Validators.required],
      Business_Overview: ['', Validators.required],
      Validity_of_Consumer: ['', Validators.required],
      Agent_Name: ['', Validators.required],
      Agent_ID: ['', Validators.required]
    })
  }

  prePopulate(id: any) {
    this.api.getConsumerDataById(id).subscribe(response => {
      // console.log(response)
      this.consumerData=response;
      console.log(this.consumerData);
    })

  }



  onSubmit() {
    this.http.put<any>('http://localhost:3000/consumer', this.consumerUpdateForm.value)
      .subscribe({
        
        next: data => {
          if(data.ID==this.consumerUpdateForm.value.ID){
            
          }
          // this.CONSUMER_ID = data.CONSUMER_ID;
          // this.CONSUMER_NAME = data.CONSUMER_NAME;
          
        },
        error: error => {
          alert(this.consumerUpdateForm.value);
        }
      });

  }
}

