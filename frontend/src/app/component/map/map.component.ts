import { AfterViewInit, Component, Input, OnInit, ViewChild } from '@angular/core';
import * as L from 'leaflet';

// https://www.digitalocean.com/community/tutorials/angular-angular-and-leaflet
@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css'],
})
export class MapComponent implements OnInit, AfterViewInit {
  private map: L.Map | undefined;
  private trailMap: L.GeoJSON | undefined;

  private _trail: any;

  @Input() set trail(trail: any) {
    this._trail = trail;
    this.updateTrail();
  }

  @ViewChild("map") mapEl: any;

  constructor() {}

  private initMap(): void {
    this.map = L.map(this.mapEl.nativeElement, {
      center: [39.8282, -98.5795],
      zoom: 3
    });

    const tiles = L.tileLayer(
      'https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png',
      {
        maxZoom: 18,
        minZoom: 3,
        attribution:
          '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>',
      }
    );

    this.trailMap = L.geoJSON();

    tiles.addTo(this.map);
    this.trailMap.addTo(this.map);

    this.updateTrail();
  }

  private updateTrail() {
    if (this._trail && this.trailMap) {
      this.trailMap?.clearLayers();
      this.trailMap?.addData(this._trail);
      this.map?.flyTo(this.trailMap.getBounds().getCenter());
    }
  }

  ngAfterViewInit(): void {
    this.initMap();
  }

  ngOnInit(): void {}
}
