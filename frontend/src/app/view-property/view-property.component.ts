import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiService } from '../shared/api.service';
import { PropertyData } from './Property.model';

@Component({
  selector: 'app-view-property',
  templateUrl: './view-property.component.html',
  styleUrls: ['./view-property.component.css'],
})
export class ViewPropertyComponent implements OnInit {
  // public addPropertyForm!: FormGroup
  public pidForm!: FormGroup;
  allPropertyData: any;
  Obj: PropertyData = new PropertyData();
  constructor(
    private formBuilder: FormBuilder,
    private http: HttpClient,
    private router: Router,
    private route: ActivatedRoute,
    private api: ApiService
  ) {}

  ngOnInit(): void {
    // this.addPropertyForm=this.formBuilder.group({
    //   ID:['',Validators.required],
    //   Business_ID:['',Validators.required],
    //   Consumer_ID:['',Validators.required],
    //   Insurance_Type:['',Validators.required],
    //   Property_Type:['',Validators.required],
    //   Building_Sqft:['',Validators.required],
    //   Building_Type:['',Validators.required],
    //   Building_Storeys:['',Validators.required],
    //   Building_Age:['',Validators.required],
    //   Property_Value:['',Validators.required],
    //   Cost_of_the_asset:['',Validators.required],
    //   Salvage_value:['',Validators.required],
    //   Useful_Life_of_the_Asset:['',Validators.required],
    // })

    this.pidForm = this.formBuilder.group({
      pid: ['', Validators.required],
    });

    // this.getAllPropertyData();
  }

  // createConsumer() {
  //   // this.Obj.ID = this.addPropertyForm.value.ID;
  //   // this.Obj.Business_ID = this.addPropertyForm.value.Business_ID;
  //   // this.Obj.Consumer_ID = this.addPropertyForm.value.Consumer_ID;
  //   // this.Obj.Insurance_Type = this.addPropertyForm.value.Insurance_Type;
  //   // this.Obj.Property_Type = this.addPropertyForm.value.Property_Type;
  //   // this.Obj.Building_Sqft = this.addPropertyForm.value.Building_Sqft;
  //   // this.Obj.Building_Type = this.addPropertyForm.value.Building_Type;
  //   // this.Obj.Building_Storeys = this.addPropertyForm.value.Building_Storeys;
  //   // this.Obj.Building_Age = this.addPropertyForm.value.Building_Age;
  //   // this.Obj.Property_Value = this.addPropertyForm.value.Property_Value;
  //   // this.Obj.Cost_of_the_asset = this.addPropertyForm.value.Cost_of_the_asset;
  //   // this.Obj.Salvage_value = this.addPropertyForm.value.Salvage_value;
  //   // this.Obj.Useful_Life_of_the_Asset =
  //   //   this.addPropertyForm.value.Useful_Life_of_the_Asset;

  //   this.api.postCreateProperty(this.Obj).subscribe(
  //     (res) => {
  //       console.log(res);
  //       alert('Property Created Successfully!!');
  //       let ref = document.getElementById('clear');
  //     },
  //     (err) => {
  //       alert('Something went wrong');
  //     }
  //   );
  // }

  getAllPropertyData() {
    let tokenStr = localStorage.getItem('token');
    let tokenStr1 = 'Bearer ' + tokenStr;

    const headers = new HttpHeaders().set('Authorization', tokenStr1);
    let _pid = this.pidForm.value.pid;
    console.log('pid from form: ', _pid);
    // this.api.getProperty(this.pidForm.value.pid, headers).subscribe((res) => {
    //   console.log('Result' + res.value);
    //   this.allPropertyData = res;
    // });

    this.api
      .getProperty(_pid, headers)
      .toPromise()
      .then((res) => {
        let data = JSON.parse(res);
        this.allPropertyData = data;
        console.log('proprties data', this.allPropertyData);
      })
      .catch((err) => {
        console.log('Error: ', err);
      });
  }
}
