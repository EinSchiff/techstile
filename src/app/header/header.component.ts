import { Component, ComponentFactoryResolver, OnInit, ViewChild, ViewContainerRef } from '@angular/core';
import { HomeComponent } from '../home/home.component';
import { AboutUsComponent } from '../about-us/about-us.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  selectedTab = 0; // Initially selected tab index
  tabs = [
    { title: 'Home', route: '/home' },
    { title: 'About Us', route: '/about-us' },
  ];

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  selectTab(index: number): void {
    this.selectedTab = index;
    this.router.navigate([this.tabs[index].route]);  // Navigate to the selected tab route
  }
}