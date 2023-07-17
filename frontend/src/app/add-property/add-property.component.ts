import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-property',
  templateUrl: './add-property.component.html',
  styleUrls: ['./add-property.component.css'],
})
export class AddPropertyComponent implements OnInit {
  public addPropertyForm!: FormGroup;
  constructor(
    private formBuilder: FormBuilder,
    private http: HttpClient,
    private router: Router
  ) {}

  public propertyData = {
    pid: null,
    area: null,
    propertyType: null,
    insuranceType: null,
    buildingType: null,
    propertyValue: null,
    costOfAsset: null,
    salvageValue: null,
    usefulLifeOfAsset: null,
    age: null,
    storey: null,
  };

  ngOnInit(): void {
    this.addPropertyForm = this.formBuilder.group({
      ID: ['', Validators.required],
      // Business_ID: ['', Validators.required],
      Consumer_ID: ['', Validators.required],
      Insurance_Type: ['', Validators.required],
      Property_Type: ['', Validators.required],
      Building_Sqft: ['', Validators.required],
      Building_Type: ['', Validators.required],
      Building_Storeys: ['', Validators.required],
      Building_Age: ['', Validators.required],
      Property_Value: ['', Validators.required],
      Cost_of_the_asset: ['', Validators.required],
      Salvage_value: ['', Validators.required],
      Useful_Life_of_the_Asset: ['', Validators.required],
    });
  }

  onSubmit() {
    console.log(this.addPropertyForm.value);

    const baseUrl = 'http://localhost:8080/createBusinessProperty';
    const url = baseUrl + '?id=' + this.addPropertyForm.value.Consumer_ID;

    this.propertyData.pid = this.addPropertyForm.value.ID;
    this.propertyData.area = this.addPropertyForm.value.Building_Sqft;
    this.propertyData.propertyType = this.addPropertyForm.value.Property_Type;
    this.propertyData.insuranceType = this.addPropertyForm.value.Insurance_Type;
    this.propertyData.buildingType = this.addPropertyForm.value.Building_Type;
    this.propertyData.propertyValue = this.addPropertyForm.value.Property_Value;
    this.propertyData.costOfAsset = this.addPropertyForm.value.costOfAsset;
    this.propertyData.salvageValue = this.addPropertyForm.value.Salvage_value;
    this.propertyData.usefulLifeOfAsset =
      this.addPropertyForm.value.Useful_Life_of_the_Asset;
    this.propertyData.age = this.addPropertyForm.value.Building_Age;
    this.propertyData.storey = this.addPropertyForm.value.storey;

    const jsonStr = JSON.stringify(this.propertyData);
    const jsonobj = JSON.parse(jsonStr);
    let tokenStr=localStorage.getItem('token');  

    //console.log(tokenStr);      

    let tokenStr1 = 'Bearer ' + tokenStr;

    const headers = new HttpHeaders().set('Authorization', tokenStr1); 
    this.http.post<any>(url, jsonobj,{headers, responseType: 'text' as 'json' }).subscribe(
      (res) => {
        alert('Details Added successfully');
        this.addPropertyForm.reset();
        this.router.navigate(['home']);
      },
      (err) => {
        alert('Something went wrong');
      }
    );
  }
}
