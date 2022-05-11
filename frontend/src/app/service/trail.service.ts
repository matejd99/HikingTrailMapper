import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject, Observable } from 'rxjs';
import { Trail } from '../contracts/models';
import { CreateTrailRequest } from '../contracts/requests';

@Injectable({
  providedIn: 'root',
})
export class TrailService {
  public trails: BehaviorSubject<Trail[]> = new BehaviorSubject<Trail[]>([]);

  constructor(private httpClient: HttpClient, private router: Router) {}

  public getTrails(): void {
    this.trails.next([]);

    this.httpClient
      .get<Trail[]>('http://localhost:7070/trail/')
      .subscribe((trails) => this.trails.next(trails));
  }

  public getTrail(trailId: number): Observable<Trail> {
    return this.httpClient.get<Trail>(
      `http://localhost:7070/trail/one/${trailId}`
    );
  }

  public getMyTrails(userId: number): void {
    this.trails.next([]);

    this.httpClient
      .get<Trail[]>(`http://localhost:7070/trail/${userId}`)
      .subscribe((trails) => this.trails.next(trails));
  }

  public postTrail(userId: number, request: CreateTrailRequest): void {
    this.httpClient
      .post<Trail>(`http://localhost:7070/trail/${userId}`, request)
      .subscribe((trail) => {
        this.trails.next(this.trails.value.splice(0, 0, trail));
        this.router.navigate(['']);
      });
  }

  public updateTrail(
    userId: number,
    trailId: number,
    request: CreateTrailRequest
  ): void {
    this.httpClient
      .put<Trail>(`http://localhost:7070/trail/${userId}/${trailId}`, request)
      .subscribe((trail) => {
        this.trails.next(
          this.trails.value.map((x) => (x.id === trailId ? trail : x))
        );
        this.router.navigate(['']);
      });
  }

  public deleteTrail(userId: number, trailId: number): void {
    this.httpClient
      .delete<Trail>(`http://localhost:7070/trail/${userId}/${trailId}`)
      .subscribe(() => {
        this.trails.next(this.trails.value.filter((x) => x.id !== trailId));
      });
  }
}
