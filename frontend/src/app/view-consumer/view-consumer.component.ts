import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ConsumerComponent } from '../consumer/consumer.component';
import { ApiService } from '../shared/api.service';
import { ConsumerData } from './Consumer.model';

@Component({
  selector: 'app-view-consumer',
  templateUrl: './view-consumer.component.html',
  styleUrls: ['./view-consumer.component.css']
})
export class ViewConsumerComponent implements OnInit {
  Obj: ConsumerData= new ConsumerData;
  allConsumerData: any;
  consumerForm !:FormGroup;
  
  constructor(private formBuilder:FormBuilder, private api:ApiService, private router:Router) { }
  ngOnInit(): void {
    this.consumerForm=this.formBuilder.group({
      ID:[''],
      First_Name:[''],
      Last_Name:[''],
      DOB:[''],
      Business_Name:[''],
      PAN_Details:[''],
      Email:[''],
      Phone:[''],
      Website:[''],
      Business_Overview:[''],
      Validity_of_Consumer:[''],
      Agent_Name:[''],
      Agent_ID:[''],
    })
    this.getAllConsumerData()
  }

  createConsumer(){
    this.Obj.ID=this.consumerForm.value.ID;
    this.Obj.First_Name=this.consumerForm.value.First_Name;
    this.Obj.Last_Name=this.consumerForm.value.Last_Name;
    this.Obj.DOB=this.consumerForm.value.DOB;
    this.Obj.Business_Name=this.consumerForm.value.Business_Name;
    this.Obj.PAN_Details=this.consumerForm.value.PAN_Details;
    this.Obj.Email=this.consumerForm.value.Email;
    this.Obj.Phone=this.consumerForm.value.Phone;
    this.Obj.Website=this.consumerForm.value.Website;
    this.Obj.Business_Overview=this.consumerForm.value.Business_Overview;
    this.Obj.Validity_of_Consumer=this.consumerForm.value.Validity_of_Consumer;
    this.Obj.Agent_Name=this.consumerForm.value.Agent_Name;
    this.Obj.Agent_ID=this.consumerForm.value.Agent_ID;

    this.api.postCreateConsumer(this.Obj).subscribe(res=>{
      console.log(res);
      alert("Consumer Created Successfully!!");
      let ref=document.getElementById('clear');
      this.consumerForm.reset();
    },err=>{
      alert("Something went wrong");
    })
  }

  getAllConsumerData(){
    this.api.getConsumer().subscribe(res=>{
      console.log("Result"+res.value);
      this.allConsumerData=res;
    })
  }

  editConsumer(id:any){
    this.router.navigate(['updateConsumer',id])
    console.log(id);
  }

}
